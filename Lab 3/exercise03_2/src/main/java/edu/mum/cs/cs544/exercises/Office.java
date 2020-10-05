package edu.mum.cs.cs544.exercises;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {
    @Id
    private int roomnumber;
    private String building;

    @OneToMany(mappedBy = "office", cascade = CascadeType.PERSIST)
    private List<Employee> employees = new ArrayList<>();

    public Office() {
    }

    public Office(int roomnumber, String building) {
        this.roomnumber = roomnumber;
        this.building = building;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void add(List<Employee> employee) {
        this.employees.addAll(employees);
    }

    public boolean remove(Employee employee) {
        return employees.remove(employee);
    }

    public boolean remove(List<Employee> employee) {
        return this.employees.removeAll(employees);
    }

    @Override
    public String toString() {
        return "Office [roomnumber=" + roomnumber + ", building=" + building + "]";
    }
}

