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
@Table(name = "room", schema = "carpool", catalog = "")
public class RoomEntity {
    private int id;
    private String roomname;
    private String startPoint;
    private String endPoint;
    private int numberLimit;
    private int currentNums;
    private Timestamp createTime;
    private int state;
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
    @Column(name = "roomname", nullable = false, length = 10)
    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
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
    @Column(name = "endPoint", nullable = false, length = 10)
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Basic
    @Column(name = "numberLimit", nullable = false)
    public int getNumberLimit() {
        return numberLimit;
    }

    public void setNumberLimit(int numberLimit) {
        this.numberLimit = numberLimit;
    }

    @Basic
    @Column(name = "currentNums", nullable = false)
    public int getCurrentNums() {
        return currentNums;
    }

    public void setCurrentNums(int currentNums) {
        this.currentNums = currentNums;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

        RoomEntity that = (RoomEntity) o;

        if (id != that.id) return false;
        if (numberLimit != that.numberLimit) return false;
        if (currentNums != that.currentNums) return false;
        if (state != that.state) return false;
        if (roomname != null ? !roomname.equals(that.roomname) : that.roomname != null) return false;
        if (startPoint != null ? !startPoint.equals(that.startPoint) : that.startPoint != null) return false;
        if (endPoint != null ? !endPoint.equals(that.endPoint) : that.endPoint != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roomname != null ? roomname.hashCode() : 0);
        result = 31 * result + (startPoint != null ? startPoint.hashCode() : 0);
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        result = 31 * result + numberLimit;
        result = 31 * result + currentNums;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
