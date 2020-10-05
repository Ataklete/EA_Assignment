package edu.mum.cs.cs544.exercises;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private String studentid;
    private String firstname;
    private String lastname;

    public Student() {
    }

    public Student(String studentid, String firstname, String lastname) {
        super();
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }


}
