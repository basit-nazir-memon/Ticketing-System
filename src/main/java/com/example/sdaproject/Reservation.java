package com.example.sdaproject;

import java.sql.Date;

public class Reservation {
    Event event;
    User user;
    Transaction transaction;
    String name;
    String cnic;
    String contact;
    int Quantity;

    public Reservation(User user, Event e){
        this.user = user;
        this.event = e;
    }
    void makeReservation(String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type){
        transaction = new Transaction();
        transaction.processPayment(type, quantity*event.getPrice(), carNumber, nameOnCard, CVV, doe);
        PersistanceHandlerController.getInstance().addReservation(event, name, cnic, contact, quantity, carNumber, nameOnCard, CVV, doe, type);
    }

    void ReservationLoad(String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type){
        transaction = new Transaction();
        transaction.processPayment(type, quantity*event.getPrice(), carNumber, nameOnCard, CVV, doe);
    }

    void makeReservation(String name, String cnic, String contact, int quantity, String accountNo, String type){
        transaction = new Transaction();
        transaction.processPayment(type, quantity*event.getPrice(), accountNo);
    }
}
