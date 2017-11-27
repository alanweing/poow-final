package me.alanwe.poowfinal.services;

import me.alanwe.poowfinal.dao.TokenDao;
import me.alanwe.poowfinal.models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Override
    @Transactional
    public void create(final Token token) {
        tokenDao.create(token);
    }
}
