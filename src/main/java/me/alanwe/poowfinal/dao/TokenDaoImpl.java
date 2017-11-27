package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Token;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TokenDaoImpl implements TokenDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Token token) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(token);
    }

    @Override
    public Token get(String token) {
        return null;
    }
}
