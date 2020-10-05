package io.ati.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
    private String paydate;
    private double amount;
}
