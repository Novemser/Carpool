package com.carpool.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project: Carpool
 * Package: com.carpool.domain
 * Author:  Novemser
 * 2016/11/29
 */
public class UserParticipateRoomEntityPK implements Serializable {
    private String userid;
    private int roomid;

    @Column(name = "userid", nullable = false, length = 10)
    @Id
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Column(name = "roomid", nullable = false)
    @Id
    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserParticipateRoomEntityPK that = (UserParticipateRoomEntityPK) o;

        if (roomid != that.roomid) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + roomid;
        return result;
    }
}
