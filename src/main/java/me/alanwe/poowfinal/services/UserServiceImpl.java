package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.dao.UserDao;
import me.alanwe.poowfinal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Set<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void createUser(final User user) {
        userDao.create(user);
    }

}
