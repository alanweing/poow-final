package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="likes", schema="poow")
public class Like {

    @Embeddable
    public static class PK implements Serializable {
        @Column(name="user_id")
        protected int userId;
        @Column(name="twit_id")
        protected int twitId;

        public PK() {}

        public PK(final int userId, final int twitId) {
            this.userId = userId;
            this.twitId = twitId;
        }

        public int getUserId() {
            return userId;
        }

        public int getTwitId() {
            return twitId;
        }
    }

    @EmbeddedId
    private PK pk;

    public PK getPk() {
        return pk;
    }

    public void setPk(PK pk) {
        this.pk = pk;
    }

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="twit_id", nullable=false, updatable=false, insertable=false)
    private Twit twit;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false, updatable=false, insertable=false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Like() {
        createdAt = new Date();
    }

    public Twit getTwit() {
        return twit;
    }

    public void setTwit(Twit twit) {
        this.twit = twit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
