package com.example.sdaproject;

import java.sql.Date;

public class Payment {
    String type;
    String Status;
    public Payment(String type){
        this.type = type;
    }

    SingletonBankingSystem bk = SingletonBankingSystem.getInstance();
    public String makePayment(String cardNumber, String nameOnCard, String cvv, Date doe, int amount){
        return bk.processPayment(cardNumber, nameOnCard, cvv, doe, amount);
    }

    public String makePayment(String accountNo, int amount){
        return bk.processPayment(accountNo, amount);
    }
}
