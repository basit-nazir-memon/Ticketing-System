package com.example.sdaproject;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class Event {
    private int id;
    private String name;
    private Date date;
    private Time time;
    private String location;
    private String description;
    private String picture;
    private int numberOfTickets;
    private int price;
    private int user_id;

    public int getUser_id(){return user_id;}
    private ArrayList<Coupon> coupons;

    private ArrayList<Campaign> campaigns;

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public ArrayList<Campaign> getCampaigns() {
        return campaigns;
    }

    public Event(int id, String name, Date date, Time time, String location, String description, String picture,
                 int numberOfTickets, int price, int user_id) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.picture = picture;
        this.numberOfTickets = numberOfTickets;
        this.price = price;
        this.user_id = user_id;
        coupons = new ArrayList<>();
        campaigns = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public int getPrice() {
        return price;
    }

    public void createCoupon(int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons, String code) {
        Coupon coupon = new Coupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons, code);
        coupons.add(coupon);
    }

    public void createCampaign(int id, String picture, String description, Date startDate, Date endDate, Event event, String plan, Coupon coupon) {
        Campaign campaign = new Campaign(id, picture, description, startDate, endDate, event, plan, coupon);
        campaigns.add(campaign);
    }

    public void editCampaign(String description, Date startDate, Date endDate, int coupon_id, int campaignId){
        for (Coupon c: coupons){
            if (c.getId() == coupon_id){
                for (Campaign cm: campaigns){
                    if (cm.getId() == campaignId){
                        cm.updateCampaign(description, startDate, endDate, c);
                        return;
                    }
                }
            }
        }
    }

    public void editCoupon(int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        for (Coupon c: coupons){
            if (c.getId() == id){
                c.updateCoupon(description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
                return;
            }
        }
    }
}
