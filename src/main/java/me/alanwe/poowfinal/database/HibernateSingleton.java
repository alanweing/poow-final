package me.alanwe.poowfinal.database;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class HibernateSingleton {

    public HibernateSingleton() {

    }

}
