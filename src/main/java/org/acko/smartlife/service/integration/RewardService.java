package org.acko.smartlife.service.integration;

import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;

import java.util.List;

/**
 * @author prabodh.hend
 */
public interface RewardService {

    public void updateRewards(Checkup checkup, List<CheckupDetails> checkupDetailsList);
}
