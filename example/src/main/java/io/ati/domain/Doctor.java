package io.ati.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private int id;
    private String doctortype;
    private String firstname;
    private String lastname;
}
