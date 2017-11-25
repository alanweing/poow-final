package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="followers", schema="poow")
public class Follower {

    @Column(name="user_id", nullable=false)
    private int userId;

    @Column(nullable=false)
    private int follows;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Follower() {}

    public Follower(int userId, int follows) {
        this.userId = userId;
        this.follows = follows;
        this.createdAt = new Date();
    }

    public int getUserId() {
        return userId;
    }

    public int getFollows() {
        return follows;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
