package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "passenger_id")
    @OrderBy("date ASC")
    List<Flight> flights = new ArrayList<>();

    public Passenger() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Passenger(String name) {
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

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addFlight(List<Flight> flights) {
        this.flights.addAll(flights);
    }

    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    public boolean removeFlight(List<Flight> flights) {
        return this.flights.removeAll(flights);
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger [id=" + id + ", name=" + name + ", flights=" + flights + "]";
    }
}
