package org.example;

import org.example.Entities.Address;
import org.example.Entities.BaseEntity;
import org.example.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory setUp() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.mergeProperties(getProperties())
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Address.class);
            sessionFactory = configuration.buildSessionFactory();
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

    public static void saveEntity(BaseEntity o) {
        try (Session session = setUp().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(o);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static User find(int id, Class<? extends BaseEntity> clazz){
        User result = null;
        String table = clazz.getSimpleName();
        try(Session session = setUp().openSession()) {
            session.getTransaction().begin();
            result = session.createSelectionQuery("from ?1 where id=?2", User.class)
                    .setParameter(1, table)
                    .setParameter(2, id)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        catch (Exception e){
        }
        System.out.println(table);
        return result;
    }

    public static List<User> getEntitiesByLastName(String lastName) {
        List<User> result = null;
        try (Session session = setUp().openSession()) {
//            String query = String.format("from User where lastName=" + lastName + "\"");
            result = session.createQuery("from User where lastName=?1", User.class)
                    .setParameter(1, lastName)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
