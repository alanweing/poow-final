package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Like;

public interface LikeDao {

    void create(Like like);
    void delete(Like like);
    void delete(Like.PK pk);

}
