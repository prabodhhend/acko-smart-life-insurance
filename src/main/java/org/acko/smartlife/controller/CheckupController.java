package org.acko.smartlife.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.models.dto.CheckupResponse;
import org.acko.smartlife.service.CheckupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author prabodh.hend
 */
@RestController
@RequestMapping("api/v1")
@Slf4j
@Api(value = "CheckupController", description = "User checkup Management", tags = {"User checkup Management"})
public class CheckupController {

    @Autowired
    private CheckupService checkupService;

    @GetMapping("/checkup-details/{userId}")
    public ResponseEntity<List<CheckupResponse>> getCheckupDetails(@PathVariable("userId") Long userId) {
        log.info("Fetching checkup details for user:{}", userId);
        List<CheckupResponse> response = checkupService.getDetails(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //getLast checkup

    //create checkup details

    //add checkup parameter

}
