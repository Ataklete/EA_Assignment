package cs544.exercise17_1.bank.service;

import org.springframework.stereotype.Component;

@Component
public interface ICurrencyConverter {
    public double euroToDollars(double amount);

    public double dollarsToEuros(double amount);
}
