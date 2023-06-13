package com.example.sdaproject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;

public interface PersistanceHandler {
    public String getSecurityQuestion(String username);

    public void loadUsers(ArrayList<User> usersList);
    public void loadReservations(ArrayList<Reservation> reservationsList, ArrayList<User>users, EventCatalogue catalogue );
    public void loadEvents(ArrayList<Event> eventsList);
    public void loadSupports(ArrayList<RequestSupport> supports, ArrayList<User> usersList);

    public String getSecurityAnswer(String username);

    public String setPassword(String username, String password);

    public int registerUser(String firstName, String lastName, String email, String usename, String password, String gender, String question, String answer, Date dob, boolean tnc, String role);

    public void addReservation(Event e, String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type);

    public int createEvent(String name, String location, Date date, int noOfTickets, int Price, String Desciption);

    public int createCoupon (int Eventid, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons, String code);

    public int createCampaign (String picture, String description, Date startDate, Date endDate, int event_id, String plan, int coupon_id);

    public void deleteCampaign(int CampaignId);
    
    public void editCampaign (String description, Date startDate, Date endDate, int coupon_id, int campaignId);

    public void editCoupon (int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons);
    public int createSupportRequest(int userId, int SupportPersonId, String question, String questionTopic, LocalDateTime dateTime);
    public int sendMessage(String message, Date date, int userId, int supportRequestId);


}
