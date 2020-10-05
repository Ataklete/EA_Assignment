package edu.mum.cs.cs544.exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    @MapKey(name = "studentid")
    private Map<String, Student> students = new HashMap<>();

    public School() {
        super();
        // TODO Auto-generated constructor stub
    }

    public School(String name) {
        super();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Student> getStudents() {
        return students;
    }


    public void addStudent(Student student) {
        students.put(student.getStudentid(), student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student.getStudentid(), student);
    }

    public void setStudents(Map<String, Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School [id=" + id + ", name=" + name + ", students=" + students + "]";
    }
}
