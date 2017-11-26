package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="likes", schema="poow")
public class Like {

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="twit_id", nullable=false)
    private Twit twit;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Like() {}

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
