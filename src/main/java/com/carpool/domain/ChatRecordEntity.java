package com.carpool.domin;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by qi on 2016/11/26.
 */
@Entity
@Table(name = "chatrecord", schema = "carpool")
public class ChatRecordEntity {
    private int id;
    private Date time;
    private String comment;
    private UserEntity sender;
    private RoomEntity room;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatRecordEntity that = (ChatRecordEntity) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "senderid", referencedColumnName = "id")
    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sourceUser) {
        this.sender = sourceUser;
    }



    @ManyToOne
    @JoinColumn(name = "roomid", referencedColumnName = "id")
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

}
