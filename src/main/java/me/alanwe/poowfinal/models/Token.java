package me.alanwe.poowfinal.models;

import javax.persistence.*;

@Entity
@Table(name="tokens", schema="poow")
public class Token {

    @Id
    @Column(name="user_id")
    @GeneratedValue
    private int userId;

    @Column(length=36, nullable=false, unique=true)
    private String token;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.REFRESH,
                       CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private User user;

    public Token() {}


}
