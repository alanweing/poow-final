package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tags", schema="poow")
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(length=20, nullable=false)
    private String name;

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE,
                                               CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="twit_tag", joinColumns=@JoinColumn(name="tag_id"),
               inverseJoinColumns=@JoinColumn(name="twit_id"))
    private Set<Twit> twits;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Tag() {}

    public Tag(final String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String tag) {
        this.name = tag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Set<Twit> getTwits() {
        return twits;
    }

    public void setTwits(Set<Twit> twits) {
        this.twits = twits;
    }
}
