package me.alanwe.poowfinal.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="twits", schema="poow")
public class Twit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(updatable=false)
    private int id;

    @NotNull(message="Message Can't be empty!")
    @Size(max=300, message="Can't exceed 300 characters.")
    @Column(length=300, nullable=false)
    private String message;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                        CascadeType.PERSIST, CascadeType.MERGE},
               fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy="twit", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                         CascadeType.PERSIST, CascadeType.REFRESH},
               fetch=FetchType.EAGER)
    private List<Like> likes;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                       CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="twit_id")
    private Twit twit;

    @ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.DETACH, CascadeType.MERGE,
                                                CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="twit_tag", schema="poow", joinColumns=@JoinColumn(name="twit_id"),
               inverseJoinColumns=@JoinColumn(name="tag_id"))
    private List<Tag> tags;

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

    public Twit() {
        createdAt = updatedAt = new Date();
        retwit = false;
    }

    public Twit(String message, User user, Twit twit, boolean retwit) {
        this.message = message;
        this.user = user;
        this.twit = twit;
        this.retwit = retwit;
    }

    public void add(final Like like) {
        if (likes == null) likes = new ArrayList<>();
        like.setTwit(this);
        likes.add(like);
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public boolean liked(User user) {
        for (final Like l : getLikes()) {
            if (user.getId() == l.getPk().getUserId()) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Twit{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
