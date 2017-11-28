package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Follower;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FollowerDaoImpl implements FollowerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(final Follower follower) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(follower);
    }

    @Override
    public void delete(final Follower follower) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(follower);
    }

    @Override
    public void delete(final Follower.PK pk) {
        final Session session = sessionFactory.getCurrentSession();
        final Follower f = session.get(Follower.class, pk);
        session.delete(f);
    }
}
