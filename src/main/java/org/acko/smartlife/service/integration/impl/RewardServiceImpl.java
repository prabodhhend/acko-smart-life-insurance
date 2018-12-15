package org.acko.smartlife.service.integration.impl;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.service.integration.RewardService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class RewardServiceImpl implements RewardService {

    @Override
    public void updateRewards(Checkup checkup, List<CheckupDetails> checkupDetailsList) {

    }
}
