package me.alanwe.poowfinal.dao;

import me.alanwe.poowfinal.models.Token;

public interface TokenDao {

    void create(Token token);
    Token get(String token);

}
