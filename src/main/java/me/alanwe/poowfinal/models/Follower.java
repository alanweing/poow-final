package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="followers", schema="poow")
public class Follower {

    @Embeddable
    public static class PK implements Serializable {
        @Column(name="user_id", nullable=false, updatable=false)
        protected int userId;

        @Column(name="follows", nullable=false, updatable=false)
        protected int follows;

        public PK() {}

        public PK(final int userId, final int follows) {
            this.userId = userId;
            this.follows = follows;
        }
    }

    @EmbeddedId
    private PK pk;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false, updatable=false, insertable=false)
    private User user;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="follows", nullable=false, updatable=false, insertable=false)
    private User follows;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Follower() {
        this.createdAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public PK getPk() {
        return pk;
    }

    public void setPk(PK pk) {
        this.pk = pk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFollows() {
        return follows;
    }

    public void setFollows(User follows) {
        this.follows = follows;
    }
}