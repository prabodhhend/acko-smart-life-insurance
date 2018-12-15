package org.acko.smartlife.controller;

import javax.persistence.Column;
import java.util.Date;

public class UserActivityPojo {


    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTotalCalories() {
            return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    private Integer totalCalories;

}
