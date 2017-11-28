package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Twit;
import me.alanwe.poowfinal.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class TwitDaoImpl implements TwitDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Twit> getTwits(final int number) {
        final Session session = sessionFactory.getCurrentSession();
        final Query<Twit> query = session.createQuery("from Twit order by createdAt desc", Twit.class);
        query.setMaxResults(number);
        try {
            final List<Twit> twits = query.getResultList();
            return twits;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Twit> getTwits(int number, User user) {
        final Session session = sessionFactory.getCurrentSession();
        final Query<Twit> query = session.createQuery("from Twit t join fetch t.user u where u.id=:id order by t.createdAt desc", Twit.class);
        query.setParameter("id", user.getId());
        query.setMaxResults(number);
        try {
            final List<Twit> twits = query.getResultList();
            return twits;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Twit> getTrending(int number) {
        final Session session = sessionFactory.getCurrentSession();
        final Query<Twit> query = session.createQuery("from Twit t order by t.likes.size desc", Twit.class);
        query.setMaxResults(number);
        try {
            final List<Twit> twits = query.getResultList();
            return twits;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void create(final Twit twit) {
        final Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(twit);
    }

    @Override
    public void delete(final Twit twit) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(twit);
    }

    @Override
    public void update(final Twit twit) {
        final Session session = sessionFactory.getCurrentSession();
        session.update(twit);
    }

    @Override
    public void delete(final int id) {
        final Session session = sessionFactory.getCurrentSession();
        final Twit twit = session.load(Twit.class, id);
        session.delete(twit);
    }

    @Override
    public Twit get(int id) {
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Twit.class, id);
    }
}
