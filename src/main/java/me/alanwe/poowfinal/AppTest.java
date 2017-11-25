package me.alanwe.poowfinal;


import me.alanwe.poowfinal.models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppTest {

    public static void main(final String... args) {
        final SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        final Session session = factory.getCurrentSession();
        try {
            final User user = new User("root", "123456", "root");
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }

}
