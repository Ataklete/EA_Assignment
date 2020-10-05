package edu.mum.cs.cs544.exercises;

import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.xml.crypto.Data;

public class AppBook {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Create new instance of Book and set values in it
            Book book1 = new Book("Ati Phylosopy", "0001", "Ati Book", 10.0, new Date());
            // save the book
            session.persist(book1);
            // Create new instance of Book and set values in it
            Book book2 = new Book("Helen Phylosopy", "0002", "Helen Book", 20.0, new Date());
            // save the book
            session.persist(book2);

            Book book3 = new Book("Henok Phlosopy", "003", "Henok Book", 30.0, new Date());
            // save the book
            session.save(book3);

            tx.commit();

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

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all books
            @SuppressWarnings("unchecked")
            List<Book> bookList = session.createQuery("from Book").list();
            for (Book book : bookList) {
                System.out.println("Title= " + book.getTitle() + ", ISBN: " + book.getISBN() + ", Author: " + book.getAuthor()
                        + ", year= " + book.getPublish_date() + ", price= " + book.getPrice());
            }
            tx.commit();

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
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // retrive book and update 
            Book book = (Book) session.load(Book.class, 1);
            book.setTitle("Changed title to spring");
            book.setPrice(40.0);
            session.persist(book);
            //  delete book
            book = (Book) session.load(Book.class, 2);
            tx.commit();
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
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            //retrive all book
            List<Book> books = session.createQuery("from Book").list();
            for (Book book : books) {
                System.out.println("Title= " + book.getTitle() + ", ISBN: " + book.getISBN() + ", Author: " + book.getAuthor()
                        + ", year= " + book.getPublish_date() + ", price= " + book.getPrice());
            }
            tx.commit();
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
