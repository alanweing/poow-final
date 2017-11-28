package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Follower;

public interface FollowerDao {

    void create(Follower follower);
    void delete(Follower follower);
    void delete(Follower.PK pk);

}
