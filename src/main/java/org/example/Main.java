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
        a1.setCity("MSk");
        a1.setStreet("Nikitskaya");
        a1.setHouseNumber(2);

        u1.setAddress(a1);
        u2.setAddress(a1);
        HibernateUtil.saveEntity(a1);
        HibernateUtil.saveEntity(u1);
        HibernateUtil.saveEntity(u2);


        User user = HibernateUtil.find(1, User.class);
        List<User> res = HibernateUtil.getEntitiesByLastName("Drago");
//        try(Session session = HibernateUtil.setUp().openSession()) {
//            List<Address> result = session.createSelectionQuery("from Address", Address.class).list();
////            result.forEach(System.out::println);
//            res = result;
//            session.getTransaction().commit();
//        }
//        catch (Exception e){
//        }
//        try {
//            user.getAddress();
//        } catch (Exception e) {
//        System.exit(0);
//        }


//        List<User> drago = HibernateUtil.getEntitiesByLastName("Drago");
//        drago.forEach(System.out::println);
    }
}