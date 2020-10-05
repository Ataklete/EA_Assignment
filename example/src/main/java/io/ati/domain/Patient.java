package io.ati.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Patient {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String street;
    private String zip;
    private String city;
}
