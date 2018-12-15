package org.acko.smartlife.models.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author prabodh.hend
 */
@Data
public class CheckupResponse {

    private Long userId;
    private String doctorName;
    private Date checkupDate;
    private String checkupType;
    private List<CheckupDetailResonse> details = new ArrayList<>();
}
