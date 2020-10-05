package edu.mum.cs.cs544.exercises;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
//	@JoinColumn(name="order_id")
    private List<Order> order = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstname, String lastname) {
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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", order=" + order + "]";
    }
}
