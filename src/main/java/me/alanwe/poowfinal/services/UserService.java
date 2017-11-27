package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.models.User;

import java.util.Set;

public interface UserService {

    Set<User> getUsers();
    void createUser(User user);

}
