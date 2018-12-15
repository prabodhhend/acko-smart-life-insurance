package org.acko.smartlife.models.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author prabodh.hend
 */
@Data
public class CheckupResponse {

    private Long userId;
    private List<CheckupDetailResonse> details = new ArrayList<>();
}
