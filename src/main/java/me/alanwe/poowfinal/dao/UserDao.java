package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.User;

import java.util.Set;

public interface UserDao {

    Set<User> getUsers();
    void create(User user);

}
