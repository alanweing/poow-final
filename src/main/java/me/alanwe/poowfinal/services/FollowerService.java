package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.models.Follower;

public interface FollowerService {

    void create(Follower follower);
    void delete(Follower follower);
    void delete(Follower.PK pk);

}
