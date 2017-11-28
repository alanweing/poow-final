package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.dao.LikeDao;
import me.alanwe.poowfinal.models.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Override
    @Transactional
    public void create(final Like like) {
        likeDao.create(like);
    }

    @Override
    @Transactional
    public void delete(final Like like) {
        likeDao.delete(like);
    }

    @Override
    @Transactional
    public void delete(final Like.PK pk) {
        likeDao.delete(pk);
    }
}
