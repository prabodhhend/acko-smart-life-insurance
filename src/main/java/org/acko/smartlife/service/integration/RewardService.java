package org.acko.smartlife.service.integration;

import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.models.dao.jpa.UserActivity;

import java.util.List;

/**
 * @author prabodh.hend
 */
public interface RewardService {

    void updateRewards(Checkup checkup, List<CheckupDetails> checkupDetailsList);

    void updateRewards(UserActivity userActivity);
}
