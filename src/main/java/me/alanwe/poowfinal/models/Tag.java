package me.alanwe.poowfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tags", schema="poow")
public class Tag {

    @Column(name="twit_id", nullable=false)
    private int twitId;

    @Column(length=20, nullable=false)
    private String tag;

    public Tag() {}

    public Tag(int twitId, String tag) {
        this.twitId = twitId;
        this.tag = tag;
    }

    public int getTwitId() {
        return twitId;
    }

    public String getTag() {
        return tag;
    }
}
