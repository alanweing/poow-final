package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.auth.AuthInterceptor;
import me.alanwe.poowfinal.auth.Crypto;
import me.alanwe.poowfinal.dao.UserDao;
import me.alanwe.poowfinal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void createUser(final User user) {
        userDao.create(user);
        session.setAttribute(AuthInterceptor.USER_TAG, user);
    }

    @Override
    @Transactional
    public User authUser(final HttpServletRequest request, String login, String password) {
        final User user = userDao.getUser(login);
        if (user == null)
            return null;
        if (!Crypto.passwordMatch(password, new Crypto.HashedPassword(user.getPassword(), user.getSalt())))
            return null;

        request.getSession(true).setAttribute(AuthInterceptor.USER_TAG, user);
        return user;
    }

    @Override
    @Transactional
    public User get(final int id) {
        return userDao.get(id);
    }

}
