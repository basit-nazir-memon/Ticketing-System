package com.example.sdaproject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class SingletonTicketingSystemController {
    private static SingletonTicketingSystemController instance;
    private SingletonTicketingSystem sys = SingletonTicketingSystem.getInstance();

    private SingletonTicketingSystemController() {
        // Private constructor to prevent instantiation
    }

    public static synchronized SingletonTicketingSystemController getInstance() {
        if (instance == null) {
            instance = new SingletonTicketingSystemController();
        }
        return instance;
    }

    public String registerUser(String firstName, String lastName, String email, String username, String password,
                               String c_password, String gender, String question, String answer, Date dob,
                               boolean tnc, String role) {
        return sys.registerUser(firstName, lastName, email, username, password, c_password, gender,
                question, answer, dob, tnc, role);
    }

    public User getLoggedInUser() {
        return sys.getLoggedInUser();
    }

    public ArrayList<Event> getEvents() {
        return sys.getEvents();
    }

    public ArrayList<Event> getBookings() {
        return sys.getBookings();
    }

    public String puchaseTicket(Event event, String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type) {
        return sys.puchaseTicket(event, name, cnic, contact, quantity, carNumber, nameOnCard, CVV, doe, type);
    }

    public String puchaseTicket(Event event, String name, String cnic, String contact, int quantity, String accountNo, String type) {
        return sys.puchaseTicket(event, name, cnic, contact, quantity, accountNo, type);
    }

    public String createEvent(String name, String location, Date date, String noOfTickets, String Price, String Desciption) {
        return sys.createEvent(name, location, date, noOfTickets, Price, Desciption);
    }

    public String createCoupon(Event event, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        return sys.createCoupon(event, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
    }

    public String createCampaign(Event event, String picture, String description, Date startDate, Date endDate, String plan, Coupon coupon) {
        return sys.createCampaign(event, picture, description, startDate, endDate, plan, coupon);
    }

    public ArrayList<Event> getUserEvents() {
        return sys.getUserEvents();
    }

    public ArrayList<Campaign> getCampaigns() {
        return sys.getCampaigns();
    }

    public HashMap<Campaign, Event> getCampaignMap() {
        return sys.getCampaignMap();
    }

    public ArrayList<Coupon> getCoupons() {
        return sys.getCoupons();
    }

    public HashMap<Coupon, Event> getCouponMap() {
        return sys.getCouponMap();
    }


    public void deleteCampaign(int CampaignId) {
        sys.deleteCampaign(CampaignId);
    }

    public String editCampaign(int id, String description, Date startDate, Date endDate, int coupon_id) {
        return sys.editCampaign(id, description, startDate, endDate, coupon_id);
    }

    public String editCoupon (int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        return sys.editCoupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
    }

    public String requestSupport(String question, String topic, User user){
        return sys.requestSupport(question, topic, user);
    }

    public ArrayList<RequestSupport> getCustomerSupport(){
        return sys.getCustomerSupport();
    }
    public ArrayList<RequestSupport> getSupport(){
        return sys.getSupport();
    }

    public ArrayList<RequestSupport> getSupportRequests(){
        return sys.getSupportRequests();
    }

    public String sendMessage(String message, RequestSupport supportRequest){
        return sys.sendMessage(message, supportRequest);
    }

}

