package com.example.sdaproject;

import java.sql.Date;

public class Transaction {
    Payment pay;
    int Amount;

    public void processPayment(String type, int amount, String carNumber, String nameOnCard, String CVV, Date doe) {
        pay = new Payment(type);
        pay.makePayment(carNumber, nameOnCard, CVV, doe, amount);
    }

    public void processPayment(String type, int amount, String accNo) {
        pay = new Payment(type);
        pay.makePayment(accNo, amount);
    }
}
