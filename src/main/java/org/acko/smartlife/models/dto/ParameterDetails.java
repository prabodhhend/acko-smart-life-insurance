package org.acko.smartlife.models.dto;

import lombok.Data;
import org.acko.smartlife.constants.ParameterType;

/**
 * @author prabodh.hend
 */
@Data
public class ParameterDetails {
    private ParameterType type;
    private Object value;
}
