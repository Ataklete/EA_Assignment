package edu.mum.cs.cs544.exercises;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Reservation> reservations = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name) {
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void add(Reservation reservation) {
        reservations.add(reservation);
    }

    public void add(List<Reservation> reservations) {
        this.reservations.addAll(reservations);
    }

    public boolean cancel(Reservation reservation) {
        return reservations.remove(reservation);
    }

    public boolean cancel(List<Reservation> reservations) {
        return this.reservations.removeAll(reservations);
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", reservations=" + reservations + "]";
    }
}
