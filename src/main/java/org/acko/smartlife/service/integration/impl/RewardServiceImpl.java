package org.acko.smartlife.service.integration.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.service.integration.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class RewardServiceImpl implements RewardService {

    private static final int smoking = 500;
    private static final int bmi = 500;

    @Value("${reward.update.url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public void updateRewards(Checkup checkup, List<CheckupDetails> checkupDetailsList) {

        Gson gson = new Gson();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);




        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(gson.toJson(validateAttributeRequest), headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update rewards", e);
        }
        if (null != response && response.getStatusCode() == HttpStatus.OK) {
            log.info("success");
        } else {
            log.info("error");
        }
    }


}
}
