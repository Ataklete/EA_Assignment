package cs544.exercise16_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    //private Collection<Student> studentlist = new ArrayList<Student>();
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session session;

    public StudentDAO() {
        session = sf.getCurrentSession();
        //Transaction tx = session.beginTransaction();
        Student student = new Student(11334, "Frank", "Brown");
        Course course1 = new Course(1101, "Java", "A");
        Course course2 = new Course(1102, "Math", "B-");

        student.addCourse(course1);
        student.addCourse(course2);
        //studentlist.add(student);
        sf.getCurrentSession().save(student);
        //tx.commit();

    }

    public Student load(long studentid) {
        Student st = (Student) sf.getCurrentSession().get(Student.class, studentid);

        return st;
    }
}
