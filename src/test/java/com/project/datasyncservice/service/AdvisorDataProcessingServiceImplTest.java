package com.project.datasyncservice.service;

import com.amazonaws.services.s3.model.S3Object;
import com.climate.event.gateway.QueueGateway;
import com.project.datasyncservice.bo.AMSUserDetailBO;
import com.project.datasyncservice.config.rabbit.OrderIntentQueueNames;
import com.project.datasyncservice.dto.AMSLocationDto;
import com.project.datasyncservice.dto.AdvisorDetailDTO;
import com.project.datasyncservice.dto.S3DataDto;
import com.farmrise.orderintentservice.dto.google.*;
import com.project.datasyncservice.exception.DataSyncFileFormatException;
import com.project.datasyncservice.mapper.AdvisorDetailMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.datasyncservice.dto.google.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AdvisorDataProcessingServiceImplTest {

    @InjectMocks
    private AdvisorDataProcessingServiceImpl advisorDataProcessingService;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private AdvisorDetailRepository advisorDetailRepository;

    @Mock
    private AdvisorDetailMapper advisorDetailMapper;

    @Mock
    private GoogleMapsClientService googleMapsClientService;

    @Mock
    private QueueGateway queueGateway;

    @Test
    public void testProcessData_withValidInput_shouldPushEventToQueue() throws IOException {
        S3Object object = new S3Object();
        List<AMSUserDetailBO> userDetailBO = getAmsUserDataList();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(userDetailBO);

        object.setObjectContent(new ByteArrayInputStream(os.toByteArray()));
        object.setKey("key");

        when(queueGateway.pushEventToQueue(any(), anyString())).thenReturn(Boolean.TRUE);
        when(objectMapper.readValue(any(InputStream.class), any(TypeReference.class))).thenReturn(getAmsUserDataList());
        when(advisorDetailMapper.map(anyList())).thenReturn(getAdvisorDataList());
        advisorDataProcessingService.processData(object);

        verify(queueGateway).pushEventToQueue(any(), eq(OrderIntentQueueNames.S3_DATA_PROCESSING_QUEUE));
    }

    @Test(expected = DataSyncFileFormatException.class)
    public void testProcessData_withInvalidInput_shouldThrowException() throws IOException {
        S3Object object = new S3Object();
        object.setObjectContent(new ByteArrayInputStream("invalid".getBytes()));

        advisorDataProcessingService.processData(object);
    }

    @Test
    public void testProcessData_whenAdvisorDataPresent_shouldUpdateAdvisor() throws Exception {

        JsonNode mockJsonNode = Mockito.mock(JsonNode.class);
        Map.Entry<String, JsonNode> mockEntry = Mockito.mock(Map.Entry.class);
        Iterator<Map.Entry<String, JsonNode>> iteratorMock = Mockito.mock(Iterator.class);
        Map<String, String> valueMap = Mockito.mock(Map.class);

        when(objectMapper.convertValue(any(Object.class), eq(AdvisorDetailDTO.class))).thenReturn(getAdvisorDataList().get(0));
        when(objectMapper.valueToTree(any())).thenReturn(mockJsonNode);
        when(mockJsonNode.get(anyString())).thenReturn(mockJsonNode);
        when(mockJsonNode.asText()).thenReturn("testValue");
        when(iteratorMock.hasNext()).thenReturn(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
        when(iteratorMock.next()).thenReturn(mockEntry);
        when(mockEntry.getKey()).thenReturn("location_hierarchy_level_1_name", "location_hierarchy_level_2_name", "location_hierarchy_level_3_name");
        when(mockEntry.getValue()).thenReturn(mockJsonNode);
        when(mockJsonNode.asText()).thenReturn("location_hierarchy_level_1_desc", "location_hierarchy_level_2_desc", "location_hierarchy_level_3_desc");
        when(valueMap.getOrDefault(anyString(), eq(null))).thenReturn("value");
        when(googleMapsClientService.getFindPlaceApiResponse(anyList())).thenReturn(Mono.just(getFindPlaceResult()));
        when(googleMapsClientService.getReverseGeocodingApiResponse(anyString(), anyString())).thenReturn(Mono.just(getReverseGeoCodingResult()));
        when(advisorDetailRepository.findByAdvisorUserId(anyString())).thenReturn(Optional.of(getAdvisor()));
        when(advisorDetailMapper.map(any(AdvisorDetailDTO.class))).thenReturn(getAdvisor());
        when(advisorDetailRepository.save(any(AdvisorDetail.class))).thenReturn(getAdvisor());
        when(advisorDetailMapper.map(any(AdvisorDetail.class))).thenReturn(getAdvisorDataList().get(0));
        when(mockJsonNode.fields()).thenReturn(iteratorMock);

        advisorDataProcessingService.processData(getS3DataDto());

        verify(advisorDetailRepository).save(any(AdvisorDetail.class));
    }

    @Test
    public void testProcessData_whenAdvisorDataNotPresent_shouldSaveAdvisor() throws Exception {

        JsonNode mockJsonNode = Mockito.mock(JsonNode.class);
        Map.Entry<String, JsonNode> mockEntry = Mockito.mock(Map.Entry.class);
        Iterator<Map.Entry<String, JsonNode>> iteratorMock = Mockito.mock(Iterator.class);
        Map<String, String> valueMap = Mockito.mock(Map.class);

        when(objectMapper.convertValue(any(Object.class), eq(AdvisorDetailDTO.class))).thenReturn(getAdvisorDataList().get(0));
        when(objectMapper.valueToTree(any())).thenReturn(mockJsonNode);
        when(mockJsonNode.get(anyString())).thenReturn(mockJsonNode);
        when(mockJsonNode.asText()).thenReturn("testValue");
        when(iteratorMock.hasNext()).thenReturn(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
        when(iteratorMock.next()).thenReturn(mockEntry);
        when(mockEntry.getKey()).thenReturn("location_hierarchy_level_1_name", "location_hierarchy_level_2_name", "location_hierarchy_level_3_name");
        when(mockEntry.getValue()).thenReturn(mockJsonNode);
        when(mockJsonNode.asText()).thenReturn("location_hierarchy_level_1_desc", "location_hierarchy_level_2_desc", "location_hierarchy_level_3_desc");
        when(valueMap.getOrDefault(anyString(), eq(null))).thenReturn("value");
        when(googleMapsClientService.getFindPlaceApiResponse(anyList())).thenReturn(Mono.just(getFindPlaceResult()));
        when(googleMapsClientService.getReverseGeocodingApiResponse(anyString(), anyString())).thenReturn(Mono.just(getReverseGeoCodingResult()));
        when(advisorDetailRepository.findByAdvisorUserId(anyString())).thenReturn(Optional.empty());
        when(advisorDetailMapper.map(any(AdvisorDetailDTO.class))).thenReturn(getAdvisor());
        when(advisorDetailRepository.save(any(AdvisorDetail.class))).thenReturn(getAdvisor());
        when(advisorDetailMapper.map(any(AdvisorDetail.class))).thenReturn(getAdvisorDataList().get(0));
        when(mockJsonNode.fields()).thenReturn(iteratorMock);

        advisorDataProcessingService.processData(getS3DataDto());

        verify(advisorDetailRepository).save(any(AdvisorDetail.class));
    }

    private List<AdvisorDetailDTO> getAdvisorDataList() {
        return Collections.singletonList(AdvisorDetailDTO.builder()
                .advisorUserId("1")
                .name("name")
                .phoneNumber("904124123412")
                .locationHierarchy(getLocationHierarchy())
                .build());
    }

    private AMSLocationDto getLocationHierarchy() {
        return AMSLocationDto.builder()
                .countryCode("IN")
                .countryDesc("IN")
                .locationHierarchyLevel1Code("level1Code")
                .locationHierarchyLevel1Desc("level1Desc")
                .locationHierarchyLevel1Name("level1Name")
                .locationHierarchyLevel2Code("level2Code")
                .locationHierarchyLevel2Desc("level2Desc")
                .locationHierarchyLevel2Name("level2Name")
                .locationHierarchyLevel3Code("level3Code")
                .locationHierarchyLevel3Desc("level3Desc")
                .locationHierarchyLevel3Name("level3Name")
                .build();


    }

    private List<AMSUserDetailBO> getAmsUserDataList() {
        return Collections.singletonList(AMSUserDetailBO.builder()
                .customerId("1")
                .accountStatus("status")
                .contactPerson("contact")
                .customerType("advisor")
                .phoneNumber("904124123412")
                .build());
    }


    private AdvisorDetail getAdvisor() {
        return AdvisorDetail.builder()
                .advisorUserId("1")
                .build();
    }

    private GeoCodingApiResponseDto getReverseGeoCodingResult() {
        AddressComponentDto addressComponentDto = AddressComponentDto.builder()
                .longName("value")
                .types(Collections.singletonList("administrative_area_level_1"))
                .build();
        ResultDto resultDto = ResultDto.builder()
                .formattedAddress("testAddress")
                .addressComponents(Collections.singletonList(addressComponentDto))
                .build();
        return GeoCodingApiResponseDto.builder()
                .results(Collections.singletonList(resultDto))
                .status("OK")
                .build();
    }

    private FindPlaceApiResponseDto getFindPlaceResult() {
        GeometryDto geometryDto = GeometryDto.builder()
                .location(LocationDto.builder()
                        .lat(12312414.0)
                        .lng(121312.1)
                        .build())
                .build();
        PlaceDto placeDto = PlaceDto.builder()
                .placeId("123")
                .formattedAddress("testAddress")
                .geometry(geometryDto)
                .build();
        return FindPlaceApiResponseDto.builder()
                .candidates(Collections.singletonList(placeDto))
                .status("OK")
                .build();
    }


    private S3DataDto getS3DataDto() {
        return S3DataDto.builder().data(getAdvisorDataList().get(0)).build();
    }


}
