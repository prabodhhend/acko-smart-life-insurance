package org.acko.smartlife.service.integration.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.constants.RewardPointType;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.models.dao.jpa.UserActivity;
import org.acko.smartlife.models.integration.UpdateRewardsRequest;
import org.acko.smartlife.service.integration.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class RewardServiceImpl implements RewardService {

    private static final Double smoking = 500D;
    private static final Double bmi = 500D;

    @Value("${reward.update.url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void updateRewards(Checkup checkup, List<CheckupDetails> checkupDetailsList) {

        Gson gson = new Gson();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        List<UpdateRewardsRequest> rewardsRequestList = createRequests(checkup, checkupDetailsList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(gson.toJson(rewardsRequestList), headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, requestEntity, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update rewards", e);
        }
        if (null != response && response.getStatusCode() == HttpStatus.OK) {
            log.info("success");
        } else {
            log.info("error");
        }
    }

    private List<UpdateRewardsRequest> createRequests(Checkup checkup, List<CheckupDetails> checkupDetailsList) {
        return checkupDetailsList.stream().map(detail -> {
            UpdateRewardsRequest request = new UpdateRewardsRequest();

            request.setType(RewardPointType.ADD);
            request.setUserId(checkup.getUserId());

            switch (detail.getParameter()) {
                case BMI:
                    request.setPoints(bmi);
                    break;
                case SMOKING:
                    request.setPoints(smoking);
                    break;
            }
            return request;
        }).collect(Collectors.toList());
    }

    @Override
    public void updateRewards(UserActivity userActivity) {
        Gson gson = new Gson();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        List<UpdateRewardsRequest> rewardsRequestList = createRequests(userActivity);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(gson.toJson(rewardsRequestList), headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, requestEntity, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update rewards", e);
        }
        if (null != response && response.getStatusCode() == HttpStatus.OK) {
            log.info("success");
        } else {
            log.info("error");
        }
    }

    private List<UpdateRewardsRequest> createRequests(UserActivity userActivity) {
        List<UpdateRewardsRequest> rewardsRequestList = new ArrayList<>();
        if (null != userActivity) {
            UpdateRewardsRequest request = new UpdateRewardsRequest();

            request.setPoints(userActivity.getTotalCalories().doubleValue());
            request.setType(RewardPointType.ADD);
            request.setUserId(userActivity.getUserId());
            rewardsRequestList.add(request);
        }
        return rewardsRequestList;
    }


}
