package edu.mum.cs.cs544.exercises;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    Set<Laptop> laptops = new HashSet<>();

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

    public boolean addLaptop(Laptop laptop) {
        return laptops.add(laptop);
    }

    public boolean addLaptop(Set<Laptop> laptops) {
        return this.laptops.addAll(laptops);
    }

    public boolean removeLaptop(Laptop laptop) {
        return laptops.remove(laptop);
    }

    public boolean removeLaptop(Set<Laptop> laptops) {
        return this.laptops.removeAll(laptops);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", laptops=" + laptops
                + "]";
    }
}
