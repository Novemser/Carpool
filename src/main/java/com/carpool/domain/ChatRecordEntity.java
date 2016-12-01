package com.carpool.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by qi on 2016/11/26.
 */
@Entity
@Table
public class ChatRecordEntity {
    private int id;
    private Date commentime;
    private String commenttext;
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
    @Column(name = "commenttime", nullable = false)
    public Date getCommentime() {
        return commentime;
    }

    public void setCommentime(Date commentTime) {
        this.commentime = commentTime;
    }

    @Basic
    @Column(name = "commenttext", nullable = false)
    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commentText) {
        this.commenttext = commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatRecordEntity that = (ChatRecordEntity) o;

        if (id != that.id) return false;
        if (commentime != null ? !commentime.equals(that.commentime) : that.commentime != null) return false;
        if (commenttext != null ? !commenttext.equals(that.commenttext) : that.commenttext != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (commentime != null ? commentime.hashCode() : 0);
        result = 31 * result + (commenttext != null ? commenttext.hashCode() : 0);
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
