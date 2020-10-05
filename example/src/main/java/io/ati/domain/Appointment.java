package io.ati.domain;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String appdate;
    @ManyToOne
    @JoinColumn(name = "PATIENT")
    private Patient patient;
    @Embedded
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "DOCTOR")
    private Doctor doctor;
}
