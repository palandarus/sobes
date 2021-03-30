package utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreator {

    public static SessionFactory getSessionFactory(){
        return new Configuration().
                configure("hibernate.cfg.xml").
                buildSessionFactory();
    }

}
