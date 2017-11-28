package me.alanwe.poowfinal.services;


import me.alanwe.poowfinal.models.Like;

public interface LikeService {

    void create(Like like);
    void delete(Like like);
    void delete(Like.PK pk);

}
