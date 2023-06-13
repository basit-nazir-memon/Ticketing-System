package com.example.sdaproject;

import java.sql.Date;

public class Campaign {
    private int id;
    private String picture;
    private String description;
    private Date startDate;
    private Date endDate;
    private String plan;
    private Coupon coupon;

    public Campaign(int id, String picture, String description, Date startDate, Date endDate, Event event, String plan, Coupon coupon) {
        this.id = id;
        this.picture = picture;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
        this.coupon = coupon;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

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
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void updateCampaign(String description, Date startDate, Date endDate, Coupon coupon){
        this.description =description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coupon = coupon;
    }

}
