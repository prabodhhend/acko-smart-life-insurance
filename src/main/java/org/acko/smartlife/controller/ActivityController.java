package org.acko.smartlife.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.models.dao.jpa.UserActivity;
import org.acko.smartlife.models.dto.UserActivityPojo;
import org.acko.smartlife.service.impl.UserActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prabodh.hend
 */

@RestController
@RequestMapping("api/v1")
@Slf4j
@Api(value = "activity", description = "user activity logging calories", tags = {"user activity logging calories"})
public class ActivityController {


    @Autowired
    UserActivityServiceImpl userActivityService;


    @PostMapping("/user-activity/")
    public ResponseEntity save(@RequestBody UserActivityPojo userActivityPojo) {
        log.info("saving user activity", userActivityPojo);
        userActivityService.save(new UserActivity(userActivityPojo.getUserId(), userActivityPojo.getTotalCalories()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user-activity/pastDays/{pastDays}")
    public ResponseEntity<List<UserActivity>> getUserActivity(@PathVariable("pastDays") Integer pastDays) {
        log.info("getting  user activity for pastDays {}",pastDays );
        return new ResponseEntity<List<UserActivity>>(userActivityService.getForPastDays(pastDays),HttpStatus.OK);
    }

}
