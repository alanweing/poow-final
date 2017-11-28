package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    List<User> getUsers();
    void createUser(User user);
    User authUser(HttpServletRequest request, String login, String password);
    User get(int id);

}
