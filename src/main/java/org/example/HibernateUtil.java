package org.example;

import org.example.Entities.Address;
import org.example.Entities.BaseEntity;
import org.example.Entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;


/*тестовый класс настройки Hibrenate.SessionFactory вместо
JPA.EntityManager (этот способ более гибкий, позволяет использовать разные имплементации JPA)*/
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory setUp() {
        if (sessionFactory == null) {
            try {
            Configuration configuration = new Configuration();
            configuration.mergeProperties(getProperties())
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Address.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (Exception e) {
            System.out.println("cant read properties file");
        }
        return properties;
    }

//    public static void saveEntity(BaseEntity o) {
//        Session session = null;
//        try {
//            session = HibernateUtil.setUp().openSession();
//            session.getTransaction().begin();
//            session.persist(o);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            Objects.requireNonNull(session).close();
//        }
//    }
//
//    public static <clazz> clazz find(int id, Class<? extends BaseEntity> clazz) {
//        clazz result = null;
//        String table = clazz.getSimpleName();
//        try (Session session = setUp().openSession()) {
//            session.getTransaction().begin();
////            System.out.println("t begin");
//            result = (clazz) session.createSelectionQuery("from " + table + " where id=?1", clazz)
//                    .setParameter(1, id)
//                    .getSingleResult();
//            session.getTransaction().commit();
////            System.out.println("t end");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public static List<User> getEntitiesByLastName(String lastName) {
//        List<User> result = null;
//        try (Session session = setUp().openSession()) {
//            return result = session.createQuery("from User where lastName=?1", User.class)
//                    .setParameter(1, lastName)
//                    .list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}
