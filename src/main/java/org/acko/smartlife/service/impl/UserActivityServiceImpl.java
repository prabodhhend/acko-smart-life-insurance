package org.acko.smartlife.service.impl;

import org.acko.smartlife.dao.jpa.UserActivityRepository;
import org.acko.smartlife.models.dao.integration.User;
import org.acko.smartlife.models.dao.jpa.UserActivity;
import org.acko.smartlife.service.integration.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class UserActivityServiceImpl {

    @Autowired
    UserActivityRepository userActivityRepository;

    @Autowired
    private RewardService rewardService;

    public void save(UserActivity userActivity){
        userActivity =userActivityRepository.save(userActivity);
        rewardService.updateRewards(userActivity);
    }

    public List<UserActivity> getForPastDays(Long userId,Integer pastDays){

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -pastDays);
        Date sevenDaysAgo = cal.getTime();
        return userActivityRepository.findByUserIdAndCreatedAtBetween(userId,sevenDaysAgo,new Date());
    }

}
