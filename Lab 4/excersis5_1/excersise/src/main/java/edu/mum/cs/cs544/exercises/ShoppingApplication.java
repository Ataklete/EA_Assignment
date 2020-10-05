package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ShoppingApplication {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Creating products
            Product product1 = new Product("Galaxy Note 11", "11 inch screen, 5G-enabled, 16 GB RAM, "
                    + "512 GB internal memory, 4500 mhA battery, 48 MP back and 24 MP front camera");
            session.persist(product1);

            Product product2 = new Product("Lenovo Laptop", "17 inch touch screen, 32 GB RAM, 512 GB SSD drive, "
                    + "1 TB hard disk, 12 hour continuous battery life per single charge");
            session.persist(product2);

            Product product3 = new Product("Samsung TV", "65 inch OLED curved screen, Smart TV, universal remote, "
                    + "USB port, HDMI port, WiFi, and Bluetoo supported");
            session.persist(product3);

            Product product4 = new CD("Somewhere Over the Rainbow", "The number one selling album in Hawaii f all time", "IZ");
            session.persist(product4);

            Product product5 = new DVD("The Notebook", "A wonderful love story released in 2004", "Romance");
            session.persist(product5);

            Product product6 = new Book("Clean Code", "A Handbook of Agile Software Craftsmanship", "Robert Cecil Martin");
            session.persist(product6);

            // Creating a customer
            Customer customer1 = new Customer("Ati", "Haile");
            session.persist(customer1);

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

            // Creating an order
            Order order1 = new Order(df.parse("09/03/2020"), customer1);
//	            customer.setOrder(order);
            session.persist(order1);

            // Creating orderlines associated with a given customer's order	            
            OrderLine orderLine1 = new OrderLine(product1, 1);
            order1.add(orderLine1);
            session.persist(orderLine1);

            OrderLine orderLine2 = new OrderLine(product2, 1);
            order1.add(orderLine2);
            session.persist(orderLine2);

            session.persist(order1);

            // Creating another customer
            Customer customer2 = new Customer("Henok", "Haile");
            session.persist(customer2);

            // Creating an order
            Order order2 = new Order(df.parse("09/03/2020"), customer2);
//	            customer.setOrder(order);
            session.persist(order2);

            // Creating orderlines associated with a given customer's order	            
            OrderLine orderLine3 = new OrderLine(product1, 3);
            order2.add(orderLine3);
            session.persist(orderLine3);

            OrderLine orderLine4 = new OrderLine(product2, 4);
            order2.add(orderLine4);
            session.persist(orderLine4);

            OrderLine orderLine5 = new OrderLine(product3, 2);
            order2.add(orderLine5);
            session.persist(orderLine5);

            session.persist(order2);

            OrderLine orderLine6 = new OrderLine(product4, 1);
            order1.add(orderLine6);
            session.persist(orderLine6);

            OrderLine orderLine7 = new OrderLine(product6, 1);
            order1.add(orderLine7);
            session.persist(orderLine7);

            session.persist(order1);

            OrderLine orderLine8 = new OrderLine(product5, 1);
            order2.add(orderLine8);
            session.persist(orderLine8);

            session.persist(order2);

            tx.commit();

        } catch (HibernateException | ParseException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            @SuppressWarnings("unchecked")
            List<Customer> customers = session.createQuery("from Customer").list();

            customers.forEach(System.out::println);

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
}
