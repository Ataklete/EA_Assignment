package cs544.exercise16_2;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class StudentService {
    private StudentDAO studentdao;
    //private SessionFactory sf = HibernateUtil.getSessionFactory();
    //private Transaction tx;

    public StudentService() {
        studentdao = new StudentDAO();
    }

    // ===== Hydration-process========//
    /*
     * public Student getStud(long studentId) {
     *
     * tx = sf.getCurrentSession().beginTransaction(); Student stud =
     * studentdao.load(studentId);
     *
     * //make sure associated entities are loaded
     * Hibernate.initialize(stud.getCourselist()); if(!tx.wasCommitted())
     * tx.commit(); return stud; }
     */
    public Student getStudent(long studentid) {
        //tx = sf.getCurrentSession().beginTransaction();
        Student student = studentdao.load(studentid);
        //tx.commit();
        return student;//
    }
}
