package org.acko.smartlife.models.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author prabodh.hend
 */
@Data
public class UpdateCheckupDetails {
    private Long userId;
    private String doctorName;
    private Double billGenerated;
    private Double amountPaid;
    private Double amountDue;
    private String checkupType;
    List<ParameterDetails> detailsList = new ArrayList<>();

}
