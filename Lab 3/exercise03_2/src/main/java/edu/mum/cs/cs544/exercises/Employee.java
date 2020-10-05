package edu.mum.cs.cs544.exercises;

import javax.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int employeenumber;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "office_id")
    private Office office;

    public Employee() {

    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public int getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(int employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Employee [employeenumber=" + employeenumber + ", name=" + name + ", department=" + department
                + ", office=" + office + "]";
    }
}

