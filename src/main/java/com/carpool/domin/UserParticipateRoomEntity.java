package com.carpool.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qi on 2016/11/26.
 */
@Entity
@Table(name = "user_participate_room", schema = "carpool")
public class UserParticipateRoomEntity implements Serializable{


    private UserEntity participateUser;

    private RoomEntity room;
    @Id
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    public UserEntity getParticipateUser() {
        return participateUser;
    }

    public void setParticipateUser(UserEntity participateUser) {
        this.participateUser = participateUser;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "roomid", referencedColumnName = "id", nullable = false)
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
