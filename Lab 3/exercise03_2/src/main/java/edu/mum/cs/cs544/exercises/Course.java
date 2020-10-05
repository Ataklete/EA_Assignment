package edu.mum.cs.cs544.exercises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String coursenumber;
    private String name;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String coursenumber, String name) {
        this.coursenumber = coursenumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(String coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public void add(List<Student> students) {
        this.students.addAll(students);
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", coursenumber=" + coursenumber + ", name=" + name + ", students=" + students
                + "]";
    }
}
