package com.example.sdaproject;

import java.sql.Date;

public class Coupon {
    private int id;
    private String description;
    private Date startDate;
    private Date endDate;
    private double discount;
    private String code;
    private double minPrice;
    private double maxPrice;
    private int availableCoupons;

    public Coupon(int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons, String code) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.availableCoupons = availableCoupons;
        this.code = code;
    }

    // Getters and Setters


    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId(){return id;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getAvailableCoupons() {
        return availableCoupons;
    }

    public void setAvailableCoupons(int availableCoupons) {
        this.availableCoupons = availableCoupons;
    }

    public void updateCoupon(String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons){
        this.description = description;
        this.startDate = startDate;
        this. endDate = endDate;
        this.discount = discount;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.availableCoupons = availableCoupons;
    }

}
