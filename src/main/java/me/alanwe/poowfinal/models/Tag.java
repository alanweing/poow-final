package me.alanwe.poowfinal.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tags", schema="poow")
public class Tag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(length=20, nullable=false)
    private String tag;

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE,
                                               CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="twit_tag", joinColumns=@JoinColumn(name="tag_id"),
               inverseJoinColumns=@JoinColumn(name="twit_id"))
    private List<Twit> twits;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    public Tag() {}

    public Tag(final String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<Twit> getTwits() {
        return twits;
    }

    public void setTwits(List<Twit> twits) {
        this.twits = twits;
    }
}
