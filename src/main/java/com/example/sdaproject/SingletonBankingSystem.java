package com.example.sdaproject;

import java.sql.Date;

public class SingletonBankingSystem {
    private static SingletonBankingSystem instance;

    private SingletonBankingSystem() {
        instance = null;
    }

    public static SingletonBankingSystem getInstance() {
        if (instance == null) {
            synchronized (SingletonBankingSystem.class) {
                if (instance == null) {
                    instance = new SingletonBankingSystem();
                }
            }
        }
        return instance;
    }

    public String checkAmount(String accountNo, int amount) {
        if (amount > 30000) {
            return "Amount greater than Account Limit";
        }
        return "Available";
    }

    public String checkAmount(String cardNumber, String nameOnCard, String cvv, Date doe, int amount) {
        if (cardNumber == null || cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return "Invalid card number";
        }
        if (cvv == null || cvv.length() != 3 || !cvv.matches("\\d+")) {
            return "Invalid CVV";
        }
        if (amount > 50000) {
            return "Amount greater than account limit";
        }
        return "Available";
    }

    public String processPayment(String accountNo, int amount) {
        if (amount > 30000) {
            return "Amount greater than Account Limit";
        }
        return "Success";
    }

    public String processPayment(String cardNumber, String nameOnCard, String cvv, Date doe, int amount) {
        if (cardNumber == null || cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return "Invalid card number";
        }
        if (cvv == null || cvv.length() != 3 || !cvv.matches("\\d+")) {
            return "Invalid CVV";
        }
        if (amount > 50000) {
            return "Amount greater than account limit";
        }
        return "Success";
    }

}

