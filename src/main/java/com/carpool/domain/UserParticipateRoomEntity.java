package com.carpool.domain;

import javax.persistence.*;

/**
 * Project: Carpool
 * Package: com.carpool.domain
 * Author:  Novemser
 * 2016/11/29
 */
@Entity
@Table(name = "user_participate_room", schema = "carpool", catalog = "")
@IdClass(UserParticipateRoomEntityPK.class)
public class UserParticipateRoomEntity {
    private String userid;
    private int roomid;
    private UserEntity userByUserid;
    private UserEntity userByUserid_0;
    private RoomEntity roomByRoomid;
    private RoomEntity roomByRoomid_0;

    @Id
    @Column(name = "userid", nullable = false, length = 10)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "roomid", nullable = false)
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

        UserParticipateRoomEntity that = (UserParticipateRoomEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(UserEntity userByUserid) {
        this.userByUserid = userByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserid_0() {
        return userByUserid_0;
    }

    public void setUserByUserid_0(UserEntity userByUserid_0) {
        this.userByUserid_0 = userByUserid_0;
    }

    @ManyToOne
    @JoinColumn(name = "roomid", referencedColumnName = "id", nullable = false)
    public RoomEntity getRoomByRoomid() {
        return roomByRoomid;
    }

    public void setRoomByRoomid(RoomEntity roomByRoomid) {
        this.roomByRoomid = roomByRoomid;
    }

    @ManyToOne
    @JoinColumn(name = "roomid", referencedColumnName = "id", nullable = false)
    public RoomEntity getRoomByRoomid_0() {
        return roomByRoomid_0;
    }

    public void setRoomByRoomid_0(RoomEntity roomByRoomid_0) {
        this.roomByRoomid_0 = roomByRoomid_0;
    }
}
