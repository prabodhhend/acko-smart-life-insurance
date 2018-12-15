package org.acko.smartlife.service.mapper;

import org.acko.smartlife.constants.ParameterType;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.acko.smartlife.models.dto.CheckupDetailResonse;
import org.acko.smartlife.models.dto.CheckupResponse;
import org.acko.smartlife.models.dto.ParameterDetails;
import org.acko.smartlife.models.dto.UpdateCheckupDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author prabodh.hend
 */
public class CheckupMapper {

    public static List<CheckupResponse> map(List<Checkup> checkupList, Map<String, List<CheckupDetails>> checkupDetailsMap) {
        List<CheckupResponse> checkupResponses = new ArrayList<>();
        if (!checkupList.isEmpty()) {
            checkupResponses = checkupList.stream()
                    .map(checkup -> {
                        CheckupResponse checkupResponse = new CheckupResponse();
                        checkupResponse.setUserId(checkup.getUserId());
                        List<CheckupDetails> checkupDetailsList = checkupDetailsMap.get(checkup.getCheckupId());
                        List<CheckupDetailResonse> details = checkupDetailsList.stream()
                                .map(checkupDetails -> {
                                    CheckupDetailResonse detailResonse = new CheckupDetailResonse();

                                    detailResonse.setParameter(checkupDetails.getParameter().toString());
                                    setValue(checkupDetails, detailResonse);

                                    return detailResonse;
                                }).collect(Collectors.toList());

                        checkupResponse.setDoctorName(checkup.getDoctorName());
                        checkupResponse.setCheckupDate(checkup.getCreatedAt());
                        checkupResponse.setCheckupType(checkup.getCheckupType());
                        checkupResponse.setDetails(details);
                        return checkupResponse;

                    }).collect(Collectors.toList());
        }
        return checkupResponses;
    }

    private static void setValue(CheckupDetails checkupDetails, CheckupDetailResonse detailResonse) {
        String value = checkupDetails.getValue();
        switch (checkupDetails.getDataType()) {
            case BOOLEAN:
                detailResonse.setValue(Boolean.valueOf(value));
                break;
            case STRING:
                detailResonse.setValue(value.toString());
                break;
            case DOUBLE:
                detailResonse.setValue(Double.parseDouble(value));
                break;
        }
    }

    public static List<CheckupDetails> createDetails(String checkupId, List<ParameterDetails> details) {
        return details.stream().map(detail -> {
            CheckupDetails checkupDetails = new CheckupDetails();

            ParameterType parameterType = detail.getType();
            checkupDetails.setCheckupId(checkupId);
            checkupDetails.setDataType(parameterType.getType());
            checkupDetails.setParameter(parameterType);
            checkupDetails.setValue(detail.getValue().toString());
            return checkupDetails;
        }).collect(Collectors.toList());
    }

    public static Checkup createCheckup(String checkupId, UpdateCheckupDetails request) {
        return Checkup.builder()
                .amountDue(request.getBillGenerated() - request.getAmountPaid())
                .amountPaid(request.getAmountPaid())
                .billGenerated(request.getBillGenerated())
                .checkupDate(new Date())
                .doctorName(request.getDoctorName())
                .checkupType(request.getCheckupType())
                .checkupId(checkupId)
                .userId(request.getUserId())
                .build();
    }
}
