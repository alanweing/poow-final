package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.auth.AuthInterceptor;
import me.alanwe.poowfinal.auth.Crypto;
import me.alanwe.poowfinal.dao.TokenDao;
import me.alanwe.poowfinal.dao.UserDao;
import me.alanwe.poowfinal.models.Token;
import me.alanwe.poowfinal.models.User;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenDao tokenDao;

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

    @Override
    @Transactional
    public User authUser(final HttpServletRequest request, String login, String password) {
        final User user = userDao.getUser(login);
        if (user == null)
            return null;
        if (!Crypto.passwordMatch(password, new Crypto.HashedPassword(user.getPassword(), user.getSalt())))
            return null;
        final Token token = new Token();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        tokenDao.create(token);
        user.setToken(token);
        request.getSession(true).setAttribute(AuthInterceptor.AUTH_TOKEN_TAG, token);
        return user;
    }

}
