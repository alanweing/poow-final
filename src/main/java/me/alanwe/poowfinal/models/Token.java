package me.alanwe.poowfinal.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="tokens", schema="poow")
public class Token {

    @Id
    @Column(name="user_id")
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="user"))
    private int userId;

    @Column(length=36, nullable=false, unique=true)
    private String token;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                       CascadeType.PERSIST, CascadeType.MERGE})
    @PrimaryKeyJoinColumn(name="user_id")
    private User user;

    public Token() {}

    public String getToken() {
        return token;
    }

    public void setUserId(int userId) { this.userId = userId; }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
