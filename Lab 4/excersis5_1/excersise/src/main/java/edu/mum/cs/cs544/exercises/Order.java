package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "order_customer")
public class Order {
    @Id
    @GeneratedValue
    private int orderid;
    private Date date;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Collection<OrderLine> orderlines = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "order-id")
    private Customer customer;

    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Order(Date date, Customer customer) {
        super();
        this.date = date;
        this.customer = customer;
//		customer.setOrder(this);
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
//		customer.setOrder(this);
    }

    public Collection<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Collection<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

    public void add(OrderLine orderLine) {
        orderlines.add(orderLine);
    }

    public void add(Collection<OrderLine> orderLines) {
        this.orderlines.addAll(orderLines);
    }

    public boolean remove(OrderLine orderLine) {
        return orderlines.remove(orderLine);
    }

    public boolean remove(Collection<OrderLine> orderLines) {
        return orderlines.removeAll(orderLines);
    }

    @Override
    public String toString() {
        return "Order [orderid=" + orderid + ", date=" + date + ", orderlines=" + orderlines
                + "]";
    }


}
