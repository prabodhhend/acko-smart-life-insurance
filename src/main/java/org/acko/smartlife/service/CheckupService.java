package org.acko.smartlife.service;

import org.acko.smartlife.models.dto.CheckupResponse;
import org.acko.smartlife.models.dto.UpdateCheckupDetails;

import java.util.List;

/**
 * @author prabodh.hend
 */
public interface CheckupService {

    List<CheckupResponse> getDetails(Long userId);

    void update(UpdateCheckupDetails request);
}
