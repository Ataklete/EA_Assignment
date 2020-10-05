package edu.mum.cs.cs544.exercises;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private String studentid;
    private String firstname;
    private String lastname;

    @ManyToMany(mappedBy = "students")

    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String studentid, String firstname, String lastname) {
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void add(Course course) {
        courses.add(course);
    }

    public void add(List<Course> courses) {
        this.courses.addAll(courses);
    }

    @Override
    public String toString() {
        return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}