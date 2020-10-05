package cs544.exercise17_2;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//import javax.transaction.Transactional;
//@Component
@Transactional(propagation = Propagation.MANDATORY)
public class StudentDAO {

    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public StudentDAO() {

        Student student = new Student(11334, "Frank", "Brown");
        Course course1 = new Course(1101, "Java", "A");
        Course course2 = new Course(1102, "Math", "B-");

        student.addCourse(course1);
        student.addCourse(course2);
        //studentlist.add(student);
        sessionFactory.getCurrentSession().save(student);
    }

    public Student load(long studentid) {
        Student st = (Student) sessionFactory.getCurrentSession().get(Student.class, studentid);

        return st;
    }
}
