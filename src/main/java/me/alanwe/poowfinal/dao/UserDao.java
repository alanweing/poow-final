package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User getUser(String login);
    void create(User user);
    User get(int id);

}
