package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

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

            // Creating an employee and assigning him/her a laptop
            Employee employee = new Employee("Ati", "Haile");
            session.persist(employee);
            Laptop laptop1 = new Laptop("Asus", "Work Station", employee);
            session.persist(laptop1);

            // Creating a Passenger and flights
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

            Flight flight = new Flight("UA10258", "Chicago", "New York", df.parse("09/05/2020"));
            session.persist(flight);

            Passenger passenger = new Passenger("Henok Haile");
            passenger.addFlight(flight);
            session.persist(passenger);

            // Creating school and students            
            Student student = new Student("65847", "Ati", "Henok");
            session.persist(student);

            School school = new School("Fairfield High");
            school.addStudent(student);
            session.persist(school);

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
            Collection<Employee> employees = session.createQuery("from Employee").list();
            employees.forEach(System.out::println);

            @SuppressWarnings("unchecked")
            Collection<Passenger> passengers = session.createQuery("from Passenger").list();
            passengers.forEach(System.out::println);

            @SuppressWarnings("unchecked")
            Collection<School> schools = session.createQuery("from School").list();
            schools.forEach(System.out::println);

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
