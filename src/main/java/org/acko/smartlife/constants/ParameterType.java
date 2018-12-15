package org.acko.smartlife.constants;

/**
 * @author prabodh.hend
 */
public enum ParameterType {

    BMI(DataType.DOUBLE), SMOKING(DataType.BOOLEAN);

    private DataType type;

    ParameterType(DataType type) {
        this.type = type;
    }

    public DataType getType() {
        return type;
    }
}
