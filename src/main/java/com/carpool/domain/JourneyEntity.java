package com.carpool.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Project: Carpool
 * Package: com.carpool.domain
 * Author:  Novemser
 * 2016/11/29
 */
@Entity
@Table(name = "journey", schema = "carpool", catalog = "")
public class JourneyEntity {
    private int id;
    private String startPoint;
    private String endPoint;
    private int peerNums;
    private Timestamp startTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "startPoint", nullable = false, length = 20)
    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    @Basic
    @Column(name = "endPoint", nullable = false, length = 20)
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Basic
    @Column(name = "peerNums", nullable = false)
    public int getPeerNums() {
        return peerNums;
    }

    public void setPeerNums(int peerNums) {
        this.peerNums = peerNums;
    }

    @Basic
    @Column(name = "startTime", nullable = false)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JourneyEntity that = (JourneyEntity) o;

        if (id != that.id) return false;
        if (peerNums != that.peerNums) return false;
        if (startPoint != null ? !startPoint.equals(that.startPoint) : that.startPoint != null) return false;
        if (endPoint != null ? !endPoint.equals(that.endPoint) : that.endPoint != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startPoint != null ? startPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        result = 31 * result + peerNums;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
