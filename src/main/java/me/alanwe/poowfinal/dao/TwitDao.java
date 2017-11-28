package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Twit;
import me.alanwe.poowfinal.models.User;

import java.util.List;

public interface TwitDao {

    List<Twit> getTwits(int number);
    List<Twit> getTwits(int number, User user);
    List<Twit> getTrending(int number);
    void create(Twit twit);
    void delete(Twit twit);
    void update(Twit twit);
    void delete(int id);
    Twit get(int id);

}
