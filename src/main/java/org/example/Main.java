package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.Entities.Address;
import org.example.Entities.Task;
import org.example.Entities.User;
import org.hibernate.Session;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        CustomPersistenceUnit persistenceUnit = new CustomPersistenceUnit();
//        persistenceUnit.setJdbsUrl(jdbcUrl);
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(persistenceUnit, new HashMap());
        EntityManager em = emf.createEntityManager();

        User u1 = new User();
        u1.setName("Ivan");
        u1.setBirthday(LocalDate.of(2000, 1, 20));

        Task t2 = new Task("task 2");
        u1.setTask(t2);
        Task t1 = new Task("task 1");

        u1.setTask(t1);

        em.getTransaction().begin();

        em.persist(u1);

        em.getTransaction().commit();
        em.close();
        System.out.printf("transaction is open %b\n", em.isOpen());

        em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, 1);
        em.getTransaction().commit();

        System.out.println(user);

    }
}