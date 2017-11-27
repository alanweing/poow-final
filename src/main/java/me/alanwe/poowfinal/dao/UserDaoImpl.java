package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set<User> getUsers() {
        final Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User", User.class);
        final List<User> users = query.getResultList();
        return new HashSet<>(users);
    }

    @Override
    public User getUser(final String login) {
        final Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User u where u.login=:userLogin", User.class);
        query.setParameter("userLogin", login);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.err.println("User not found for login: ".concat(login));
            return null;
        }
    }

    @Override
    public void create(final User user) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
