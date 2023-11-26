package com.project.datasyncservice.service.impl;

import com.project.datasyncservice.bo.PreSignedUrlGenerationBO;
import com.project.datasyncservice.constants.AdvisorConstants;
import com.project.datasyncservice.dto.MobileApiResponseDto;
import com.project.datasyncservice.dto.PreSignedUrlDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@Service
public class PreSignedUrlService {

    @Value("${pre.signed.url.file.extension}")
    private String fileExtention;

    @Value("${pre.signed.url.reference.name}")
    private String referenceName;

    @Value("${pre.signed.url.count}")
    private Integer count;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PreSignedUrlDTO> getPreSignedURLs(List<String> syncDataTypes) {
        log.info("UserClientService.getPreSignedURLs() :: for {} syncDataTypes  ", syncDataTypes);
        List<PreSignedUrlGenerationBO> urlGenerationBOList = syncDataTypes.stream().parallel().map(this::getPreSignedUrlGenerationBody).collect(Collectors.toList());
        List<Object> urlList = urlGenerationBOList.stream().parallel().map(this::getPreSignedUrl).map(Mono::block)
                .filter(Objects::nonNull).map(MobileApiResponseDto::getData).collect(Collectors.toList());
        try {
            if (!urlList.isEmpty()) {
                String data = objectMapper.writeValueAsString(urlList);
                List<List<PreSignedUrlDTO>> list = objectMapper.readValue(data, new TypeReference<List<List<PreSignedUrlDTO>>>() {
                });
                List<PreSignedUrlDTO> preSignedUrlDTOList = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
                preSignedUrlDTOList.forEach(preSignedUrlDTO -> preSignedUrlDTO.setSyncDataType(getContextFromObjectKey(preSignedUrlDTO.getObjectKey())));
                return preSignedUrlDTOList;
            }
        } catch (JsonProcessingException e) {
            log.info("UserClientService.getPreSignedURLs() :: exception={}", e.getMessage());
        }
        return Collections.emptyList();
    }

    public Mono<MobileApiResponseDto> getPreSignedUrl(PreSignedUrlGenerationBO preSignedUrlGenerationBO) {
        log.info("UserClientService.getPreSignedUrl() :: for {} syncDataType  ", preSignedUrlGenerationBO);
        return null;
    }

    PreSignedUrlGenerationBO getPreSignedUrlGenerationBody(String syncDataType) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS);
        String fileName = syncDataType + "-" + zonedDateTime;
        return PreSignedUrlGenerationBO.builder()
                .fileExtention(fileExtention)
                .referenceName(referenceName)
                .count(count)
                .fileName(fileName)
                .build();
    }

    String getContextFromObjectKey(String objectKey) {
        Pattern pattern = Pattern.compile(AdvisorConstants.S3_DATA_SYNC_DATA_CONTEXT_REGEX);
        Matcher matcher = pattern.matcher(objectKey);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}