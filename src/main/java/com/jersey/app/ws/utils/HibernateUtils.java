package com.jersey.app.ws.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author Nimesha Buddhika on 7/12/2018
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        Configuration conf = new Configuration();
        conf.configure();

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
