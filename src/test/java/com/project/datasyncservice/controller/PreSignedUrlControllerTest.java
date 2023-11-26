package com.project.datasyncservice.controller;

import com.climate.bo.MobileApiResponseBO;
import com.project.datasyncservice.service.impl.PreSignedUrlService;
import com.project.datasyncservice.dto.PreSignedUrlDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PreSignedUrlControllerTest {

    private static final List<String> SYNC_DATA_TYPE = Collections.singletonList("product");
    @InjectMocks
    private PreSignedUrlController preSignedUrlController;
    @Mock
    private PreSignedUrlService preSignedUrlService;
    @Mock
    private List<PreSignedUrlDTO> resp;

    @Test
    public void getPreSignedUrl() {
        when(preSignedUrlService.getPreSignedURLs(SYNC_DATA_TYPE)).thenReturn(resp);
        ResponseEntity<MobileApiResponseBO> response = preSignedUrlController.getPreSignedUrls(SYNC_DATA_TYPE);
        Mockito.verify(preSignedUrlService).getPreSignedURLs(SYNC_DATA_TYPE);
        Assert.assertNotNull(response);
    }
}