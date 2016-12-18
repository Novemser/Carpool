package com.carpool.website.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;

/**
 * Project: Carpool
 * Package: com.carpool.website.model
 * Author:  Novemser
 * 2016/12/11
 */
public class RoomSelection {
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String startPoint;
    @NotEmpty
    private String endPoint;
    @AssertTrue
    private boolean isServiceChecked;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public boolean getIsServiceChecked() {
        return isServiceChecked;
    }

    public void setIsServiceChecked(boolean isServiceChecked) {
        this.isServiceChecked = isServiceChecked;
    }
}
