package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users", schema="poow")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(nullable=false, length=10)
    private String login;

    @Column(nullable=false, length=255)
    private String password;

    @Column(nullable=false, length=50)
    private String name;

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

    @OneToMany(mappedBy="user", cascade={CascadeType.DETACH, CascadeType.MERGE,
                                         CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Twit> twits;

    public User() {}

    public User(final String login, final String password, final String name) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void add(final Twit twit) {
        if (twits == null) twits = new ArrayList<>();
        twits.add(twit);
        twit.setUser(this);
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
}
