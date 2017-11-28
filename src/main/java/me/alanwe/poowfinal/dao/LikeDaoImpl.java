package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Like;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDaoImpl implements LikeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(final Like like) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(like);
    }

    @Override
    public void delete(final Like like) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(like);
    }

    @Override
    public void delete(final Like.PK pk) {
        final Session session = sessionFactory.getCurrentSession();
        final Like like = session.get(Like.class, pk);
        session.delete(like);
    }
}
