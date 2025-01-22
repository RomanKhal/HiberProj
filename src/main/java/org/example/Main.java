package org.example;

import org.example.Entities.Address;
import org.example.Entities.User;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory()
////        EntityManagerFactory emf = new HibernatePersistenceProvider()
////                .createContainerEntityManagerFactory(new CustomPersistenceUnit(), Map.of(
////                        "hibernate.dialect", "org.hibernate.dialect.H2Dialect",
////                        "hibernate.show_sql", "true"
////                ));
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//
//        em.getTransaction().commit();

        User u1 = new User();
        User u2 = new User();
        u1.setFirstName("Ivan");
        u1.setLastName("Drago");
        u1.setBirthday(LocalDate.of(1999, 1, 20));

        u2.setFirstName("Maria");
        u2.setLastName("Drago");
        u2.setBirthday(LocalDate.of(1969, 1, 20));

        Address a1 = new Address();
        a1.setAddressDetails("Msk", "Nikitskaya", 2, 11);


        HibernateUtil.saveEntity(a1);
        u1.setAddress(a1);
        u2.setAddress(a1);
        HibernateUtil.saveEntity(u1);
        HibernateUtil.saveEntity(u2);


//        User user = HibernateUtil.find(1, User.class);
//        System.out.println(user.getFirstName()+ " " + user.getUpdatedAt());
//
//        try {
//            System.out.println("main transact start");
//            Session s = HibernateUtil.setUp().openSession();
//            s.getTransaction().begin();
//            System.out.println(user.getFirstName()+ " " + user.getUpdatedAt());
//            user.setFirstName("Borya");
//
//            System.out.println(user.getFirstName()+ " " + user.getUpdatedAt());
////            Thread.sleep(3000);
//            s.getTransaction().commit();
//            System.out.println("main transact finish");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(user.getUpdatedAt());
//
//        User u3 = HibernateUtil.find(1, User.class);

//        System.out.println(user.getFirstName() + " " + user.getUpdatedAt());



        try {
            Session s = HibernateUtil.setUp().openSession();
            s.getTransaction().begin();
            s.remove(u2);
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Address adr = HibernateUtil.find(1, Address.class);
        List<User> users = adr.getUsers();

    }
}