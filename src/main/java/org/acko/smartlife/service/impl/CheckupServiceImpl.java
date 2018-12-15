package org.acko.smartlife.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.dao.jpa.CheckupDetailsRepository;
import org.acko.smartlife.dao.jpa.CheckupRepository;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.models.dto.CheckupResponse;
import org.acko.smartlife.service.CheckupService;
import org.acko.smartlife.service.integration.UserService;
import org.acko.smartlife.service.mapper.CheckupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class CheckupServiceImpl implements CheckupService {

    @Autowired
    private UserService userService;

    @Autowired
    private CheckupRepository checkupRepository;

    @Autowired
    private CheckupDetailsRepository checkupDetailsRepository;

    @Override
    public List<CheckupResponse> getDetails(Long userId) {
        log.info("Fetching checkup details");
        userService.validate(userId);
        List<Checkup> checkupList = checkupRepository.findByUserId(userId);
        Map<String, List<CheckupDetails> > checkupDetailsMap = new HashMap<>();
        checkupList.stream().forEach(checkup -> {
            List<CheckupDetails> details = checkupDetailsRepository.findByCheckupId(checkup.getCheckupId());
//            checkup.setCheckupDetailsList(details);
            checkupDetailsMap.put(checkup.getCheckupId(),details);
        });
        return CheckupMapper.map(checkupList,checkupDetailsMap);
    }
}
