package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="likes", schema="poow")
public class Like {

    @Column(name="twit_id", nullable=false)
    private int twitId;

    @Column(name="user_id", nullable=false)
    private int userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Like() {}

    public Like(int twitId, int userId) {
        this.twitId = twitId;
        this.userId = userId;
        this.createdAt = new Date();
    }

    public int getTwitId() {
        return twitId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
