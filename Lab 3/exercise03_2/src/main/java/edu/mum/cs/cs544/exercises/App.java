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

public class App {

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

            // 1. Creating departments and employees
            Department dept1 = new Department("Marketing");
            Department dept2 = new Department("Sales");

            Employee emp1 = new Employee("Ati", dept1);
            Employee emp2 = new Employee("Henok", dept2);

            session.persist(emp1);
            session.persist(emp2);
            // 2. Creating publishers and books and persisting them
            Publisher publ1 = new Publisher("Apress");
            Publisher publ2 = new Publisher("Pearson");

            session.persist(publ1);
            session.persist(publ2);

            Book book1 = new Book("978-1430265320", "Introducing Spring Framework: A Primer", "Felipe Gutierre", publ1);
            Book book2 = new Book("978-0321127426", "Patterns of Enterprise Application Architecture", "Martin Fowler", publ2);

            session.persist(book1);
            session.persist(book2);

            // 3. Creating students and courses and persisting them
            Student stud1 = new Student("611062", "Ati", "Haile");
            session.persist(stud1);

            Course course1 = new Course("CS544", "Enterprise Architecture");
            course1.add(stud1);
            session.persist(course1);

            Student stud2 = new Student("611051", "Henok", "Haile");
            session.persist(stud2);

            Course course2 = new Course("CS425", "Software Engiineering");
            course2.add(stud2);
            session.persist(course2);

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

            // 4. Creating customers and reservations and persisting them
            Reservation reserv1 = new Reservation(df.parse("06/15/2020"));
            session.persist(reserv1);

            Customer cust1 = new Customer("Helen Haile");
            cust1.add(reserv1);
            session.persist(cust1);

            Reservation reserv2 = new Reservation(df.parse("05/28/2020"));
            session.persist(reserv2);

            Customer cust2 = new Customer("Saba Haile");
            cust2.add(reserv2);
            session.persist(cust2);

            // 5. Creating books and reservations and persisting them
            reserv1.setBook(book2);
            reserv2.setBook(book1);

            // 6. Creating employees and offices and persisting them
            Office office = new Office(102, "McLaughlin");
            session.persist(office);

            emp1.setOffice(office);
            emp2.setOffice(office);

            session.persist(emp1);
            session.persist(emp2);

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

            // Loading from database
            List<Employee> employees = session.createQuery("from Employee").list();
            List<Book> books = session.createQuery("from Book").list();
            List<Course> courses = session.createQuery("from Course").list();
            List<Customer> customers = session.createQuery("from Customer").list();

            // Displaying to console
            System.out.println();
            employees.forEach(System.out::println);
            System.out.println();
            books.forEach(System.out::println);
            System.out.println();
            courses.forEach(System.out::println);
            System.out.println();
            customers.forEach(System.out::println);
            System.out.println();

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
