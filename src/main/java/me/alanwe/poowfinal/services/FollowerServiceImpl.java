package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.dao.FollowerDao;
import me.alanwe.poowfinal.models.Follower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerDao followerDao;

    @Override
    @Transactional
    public void create(final Follower follower) {
        followerDao.create(follower);
    }

    @Override
    @Transactional
    public void delete(final Follower follower) {
        followerDao.delete(follower);
    }

    @Override
    @Transactional
    public void delete(final Follower.PK pk) {
        followerDao.delete(pk);
    }
}
