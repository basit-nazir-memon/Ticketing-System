package com.example.sdaproject;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

public class PersistanceHandlerController {
    private PersistanceHandler db;
    private static PersistanceHandlerController instance;

    public static PersistanceHandlerController getInstance() {
        if (instance == null) {
            synchronized (PersistanceHandlerController.class) {
                if (instance == null) {
                    instance = new PersistanceHandlerController();
                }
            }
        }
        return instance;
    }

    private PersistanceHandlerController(){
        db = PersistanceHandlerFactory.createPersistanceHandler(voidGetDataStorage());
    }

    private String voidGetDataStorage(){
        Properties properties = new Properties();
        String dataStored = null;
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(fileInputStream);

            dataStored = properties.getProperty("dataStored");
            System.out.println("Data Stored: " + dataStored);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataStored;
    }
    public String getSecurityQuestion(String username){
        return db.getSecurityQuestion(username);
    }

    public String getSecurityAnswer(String username) {
        return db.getSecurityAnswer(username);
    }

    public String setPassword(String username, String password){
        return db.setPassword(username,password);
    }

    public void loadUsers(ArrayList<User> users){
        db.loadUsers(users);
    }
    public void loadReservations(ArrayList<Reservation> reservations, ArrayList<User> users, EventCatalogue catalogue){ db.loadReservations(reservations, users, catalogue); }
    public void loadEvents(ArrayList<Event> events){ db.loadEvents(events); }
    public int registerUser(String firstName, String lastName, String email, String usename, String password, String gender, String question, String answer, Date dob, boolean tnc, String role){
        return db.registerUser(firstName, lastName, email, usename, password, gender, question, answer, dob, tnc, role);
    }
    public void addReservation(Event e, String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type){
        db.addReservation(e, name, cnic, contact, quantity, carNumber, nameOnCard, CVV, doe, type);
    }

    public int createEvent(String name, String location, Date date, int noOfTickets, int Price, String Desciption){
        return db.createEvent(name, location, date, noOfTickets, Price, Desciption);
    }

    public int createCoupon (int Eventid, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons, String code){
        return db.createCoupon(Eventid, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons, code);
    }


    public int createCampaign (String picture, String description, Date startDate, Date endDate, int event_id, String plan, int coupon_id){
        return db.createCampaign(picture, description, startDate, endDate, event_id, plan, coupon_id);
    }

    public void deleteCampaign(int CampaignId){
        db.deleteCampaign(CampaignId);
    }

    public void editCampaign (String description, Date startDate, Date endDate, int coupon_id, int campaignId) {
        db.editCampaign(description, startDate, endDate, coupon_id, campaignId);
    }

    public void editCoupon (int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        db.editCoupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
    }

    public int createSupportRequest(int userId, int SupportPersonId, String question, String questionTopic, LocalDateTime dateTime){
        return db.createSupportRequest(userId, SupportPersonId, question, questionTopic, dateTime);
    }

    public int sendMessage(String message, Date date, int userId, int supportRequestId){
        return db.sendMessage(message, date, userId, supportRequestId);
    }

    public void loadSupports(ArrayList<RequestSupport> supports, ArrayList<User> usersList){
        db.loadSupports(supports, usersList);
    }

}
