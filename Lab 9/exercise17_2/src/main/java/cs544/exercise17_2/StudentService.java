package cs544.exercise17_2;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;

public class StudentService {
    private StudentDAO studentdao;

    public StudentService() {

    }

    public void setStudentdao(StudentDAO studentdao) {
        this.studentdao = studentdao;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Student getStudent(long studentid) {

        Student student = studentdao.load(studentid);

        return student;
    }
}
