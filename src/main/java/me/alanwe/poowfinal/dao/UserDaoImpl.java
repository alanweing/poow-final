package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void create(final User user) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
