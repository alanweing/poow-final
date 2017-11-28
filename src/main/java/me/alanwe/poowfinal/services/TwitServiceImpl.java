package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.auth.AuthInterceptor;
import me.alanwe.poowfinal.dao.TwitDao;
import me.alanwe.poowfinal.models.Twit;
import me.alanwe.poowfinal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TwitServiceImpl implements TwitService {

    @Autowired
    private TwitDao twitDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional
    public List<Twit> getTwits(final int number) {
        return twitDao.getTwits(number);
    }

    @Override
    @Transactional
    public List<Twit> getTwits(final int number, final User user) {
        return twitDao.getTwits(number, user);
    }

    @Override
    @Transactional
    public List<Twit> getTrending(final int number) {
        return twitDao.getTrending(number);
    }

    @Override
    @Transactional
    public void create(final Twit twit) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        twit.setUser(user);
        twitDao.create(twit);
    }

    @Override
    @Transactional
    public void delete(final Twit twit) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        if (twit.getUser().getId() == user.getId()) {
            twitDao.delete(twit);
        }
    }

    @Override
    @Transactional
    public void update(final Twit twit) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        if (twit.getUser().getId() == user.getId()) {
            twitDao.update(twit);
        }
    }

    @Override
    @Transactional
    public void delete(final int id) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        if (twitDao.get(id).getUser().getId() == user.getId()) {
            twitDao.delete(id);
        }
    }

    @Override
    @Transactional
    public Twit get(final int id) {
        return twitDao.get(id);
    }

}
