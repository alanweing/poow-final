package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="twits", schema="poow")
public class Twit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(updatable=false, unique=true)
    private int id;

    @Column(length=300, nullable=false)
    private String message;

//    @Column(name="user_id", nullable=false, updatable=false)
//    private int userId;
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="twit_id")
    private Twit twit;

//    @Column(name="twit_id", nullable=false)
//    private int twitId;

    @Column(nullable=false)
    private boolean retwit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public Twit() {}

    public Twit(String message, User user, Twit twit, boolean retwit) {
        this.message = message;
        this.user = user;
        this.twit = twit;
        this.retwit = retwit;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRetwit() {
        return retwit;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Twit getTwit() {
        return twit;
    }

    public void setTwit(Twit twit) {
        this.twit = twit;
    }
}
