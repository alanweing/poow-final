package me.alanwe.poowfinal.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users", schema="poow")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(nullable=false, length=10)
    @NotNull(message="required")
    private String login;

    @Column(nullable=false, length=255)
    @NotNull(message="required")
    @Size(min=6, message="minimum length = 6")
    private String password;

    @Column(nullable=false, length=50)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="salt", length=40)
    private String salt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = this.updatedAt = new Date();
    }

    @OneToMany(mappedBy="user", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                         CascadeType.PERSIST, CascadeType.REFRESH},
               fetch=FetchType.LAZY)
    private Set<Twit> twits;

    @OneToMany(mappedBy="twit", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                         CascadeType.PERSIST, CascadeType.REFRESH},
              fetch=FetchType.LAZY)
    private Set<Like> likes;

    @OneToMany(mappedBy="user", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                         CascadeType.PERSIST, CascadeType.REFRESH},
               fetch=FetchType.EAGER)
    private Set<Follower> follows;

    @OneToOne(mappedBy="user", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                        CascadeType.PERSIST, CascadeType.REFRESH})
    private Token token;

    public User() {
        this.createdAt = this.updatedAt = new Date();
    }

    public User(final String login, final String password, final String name, final String salt) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.salt = salt;
    }

    public void add(final Twit twit) {
        if (twits == null) twits = new HashSet<>();
        twits.add(twit);
        twit.setUser(this);
    }

    public void add(final Like like) {
        if (likes == null) likes = new HashSet<>();
        like.setUser(this);
        likes.add(like);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", salt='" + salt + '\'' +
                '}';
    }
}
