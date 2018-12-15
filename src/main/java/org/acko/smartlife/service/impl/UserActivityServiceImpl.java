package org.acko.smartlife.service.impl;

import org.acko.smartlife.dao.jpa.UserActivityRepository;
import org.acko.smartlife.models.dao.integration.User;
import org.acko.smartlife.models.dao.jpa.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserActivityServiceImpl {


    @Autowired
    UserActivityRepository userActivityRepository;

    public void save(UserActivity userActivity){

        userActivityRepository.save(userActivity);

    }


}
