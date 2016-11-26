package com.carpool.model;

import javax.persistence.*;

/**
 * Created by qi on 2016/11/26.
 */
@Entity
@Table(name = "comment", schema = "carpool")
public class CommentEntity {
    private int id;
    private String comment;
    private double credit;
    private UserEntity sourceUser;
    private UserEntity targetUser;
    private JourneyEntity journey;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "credit", nullable = false, precision = 0)
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.credit, credit) != 0) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sourceUserid", referencedColumnName = "id")
    public UserEntity getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(UserEntity sourceUserd) {
        this.sourceUser =  sourceUserd;
    }

    @ManyToOne
    @JoinColumn(name = "targetUserid", referencedColumnName = "id")
    public UserEntity getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(UserEntity targetUser) {
        this.targetUser = targetUser;
    }

    @ManyToOne
    @JoinColumn(name = "journeyid", referencedColumnName = "id", nullable = false)
    public JourneyEntity getJourney() {
        return journey;
    }

    public void setJourney(JourneyEntity journey) {
        this.journey = journey;
    }
}
