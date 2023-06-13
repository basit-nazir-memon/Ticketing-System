package com.example.sdaproject;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.Date;

public class SingletonTicketingSystem {
    private static SingletonTicketingSystem instance;
    public ArrayList<User> users;
    private ArrayList<Reservation> reservations;
    private EventCatalogue catalogue;
    private ArrayList<RequestSupport> supports;
    private SingletonTicketingSystem() {
        users = new ArrayList<>();
        catalogue = new EventCatalogue();
        reservations = new ArrayList<>();
        supports = new ArrayList<>();
        loadData();
    }

    private void loadData(){
        PersistanceHandlerController.getInstance().loadUsers(users);
        PersistanceHandlerController.getInstance().loadReservations(reservations, users, catalogue);
        PersistanceHandlerController.getInstance().loadSupports(supports, users);
    }

    public static SingletonTicketingSystem getInstance() {
        if (instance == null) {
            synchronized (SingletonTicketingSystem.class) {
                if (instance == null) {
                    instance = new SingletonTicketingSystem();
                }
            }
        }
        return instance;
    }

    public ArrayList<Event> getBookings(){
        ArrayList <Event> bookings = new ArrayList<>();
        for (Reservation r: reservations){
            if (r.user.getId() == getLoggedInUser().getId()){
                bookings.add(r.event);
            }
        }
        return bookings;
    }

    public ArrayList<Campaign> getCampaigns(){
        return catalogue.getCampaigns();
    }

    public HashMap<Campaign, Event> getCampaignMap(){
        return catalogue.getCampaignMap();
    }

    public String registerUser(String firstName, String lastName, String email, String usename, String password, String c_password, String gender, String question, String answer, Date dob, boolean tnc, String role){
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || usename.isEmpty() || password.isEmpty() || gender.isEmpty() || question.isEmpty() || answer.isEmpty() || role == null){
            return "Please Fill All the Fields";
        }
        if (dob.equals(null)){
            return "Please Enter the Date of Birth";
        }
        if (password.equals(c_password)){
            int id = PersistanceHandlerController.getInstance().registerUser(firstName, lastName, email, usename, password, gender, question, answer, dob, tnc, role);
            users.add(new User(id, firstName, lastName, usename, password, role, dob, email, gender, tnc, true));
            return "Created";
        }
        return "Password And Confirm Password Must Match";
    }

    public User getLoggedInUser(){
        return SessionStorage.getInstance().getUser();
    }

    public ArrayList<Event> getEvents(){
        return catalogue.getEvents();
    }

    public String puchaseTicket(Event event, String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type){
        String response = SingletonBankingSystem.getInstance().checkAmount(carNumber, nameOnCard, CVV, doe, event.getPrice()*quantity);
        if (response.equals("Available")){
            Reservation res = new Reservation(getLoggedInUser(), event);
            res.makeReservation(name,cnic, contact, quantity, carNumber, nameOnCard, CVV, doe, type);
            reservations.add(res);
        }
        return response;
    }

    public String puchaseTicket(Event event, String name, String cnic, String contact, int quantity, String accountNo, String type){
        String response = SingletonBankingSystem.getInstance().checkAmount(accountNo, event.getPrice()*quantity);
        if (response.equals("Available")){
            Reservation res = new Reservation(getLoggedInUser(), event);
            res.makeReservation(name,cnic, contact, quantity, accountNo, type);
            reservations.add(res);
        }
        return response;
    }

    public Event getEvent(int id){
        return catalogue.getEvent(id);
    }

    public User getUser(int id){
        for (User u : users){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }


    public String createEvent(String name, String location, Date date, String noOfTickets, String Price, String Desciption){
        if (name.isEmpty() || location.isEmpty() || noOfTickets.isEmpty() || Price.isEmpty() || Desciption.isEmpty()){
            return "Enter All Fields";
        }
        else if (date == null){
            return "Enter Date";
        }
        int id =  PersistanceHandlerController.getInstance().createEvent(name, location, date, Integer.valueOf(noOfTickets), Integer.valueOf(Price), Desciption);
        catalogue.createEvent(id, name, location, date, Integer.valueOf(noOfTickets), Integer.valueOf(Price), Desciption);
        return "Success";
    }

    private String generateUniqueCode() {
        Random random = new Random();
        Set<String> generatedCodes = new HashSet<>();

        while (true) {
            StringBuilder codeBuilder = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int digit = random.nextInt(10);
                codeBuilder.append(digit);
            }

            String code = codeBuilder.toString();

            if (!generatedCodes.contains(code)) {
                generatedCodes.add(code);
                return code;
            }
        }
    }

    public String createCoupon(Event event, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        if (event == null) {
            return "Invalid event. Cannot create coupon.";
        }
        if (description == null || description.isEmpty()) {
            return "Invalid coupon description. Please provide a valid description.";
        }
        if (startDate == null || endDate == null) {
            return "Invalid coupon dates. Please provide valid start and end dates.";
        }
        if (discount <= 0) {
            return "Invalid coupon discount. Please provide a positive discount value.";
        }
        if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice) {
            return "Invalid coupon price range. Please provide valid minimum and maximum prices.";
        }
        if (availableCoupons <= 0) {
            return "Invalid available coupons count. Please provide a positive count.";
        }
        String code = generateUniqueCode();
        int id = PersistanceHandlerController.getInstance().createCoupon(event.getId(), description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons, code);
        event.createCoupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons, code);
        return "Coupon created successfully.";
    }

    public String createCampaign(Event event, String picture, String description, Date startDate, Date endDate, String plan, Coupon coupon) {
        if (event == null) {
            return "Invalid event. Cannot create campaign.";
        }
        if (picture == null || picture.isEmpty()) {
            return "Invalid campaign picture. Please provide a valid picture.";
        }
        if (description == null || description.isEmpty()) {
            return "Invalid campaign description. Please provide a valid description.";
        }
        if (startDate == null || endDate == null) {
            return "Invalid campaign dates. Please provide valid start and end dates.";
        }
        if (plan == null || plan.isEmpty()) {
            return "Invalid campaign plan. Please provide a valid plan.";
        }
        if (coupon == null) {
            return "Invalid campaign coupon. Please provide a valid coupon.";
        }
        int id = PersistanceHandlerController.getInstance().createCampaign(picture, description, startDate, endDate, event.getId(), plan, coupon.getId());
        event.createCampaign(id, picture, description, startDate, endDate, event, plan, coupon);
        return "Campaign created successfully.";
    }

    public ArrayList<Event> getUserEvents() {
        return catalogue.getUserEvents();
    }

    public void deleteCampaign(int CampaignId){
        PersistanceHandlerController.getInstance().deleteCampaign(CampaignId);
        catalogue.deleteCampaign(CampaignId);
    }

    public String editCampaign (int id, String description, Date startDate, Date endDate, int coupon_id) {
        if (description.isEmpty() || startDate == null || endDate == null || coupon_id <= 0){
            return  "Please Fill the details correctly";
        }
        PersistanceHandlerController.getInstance().editCampaign(description, startDate, endDate, coupon_id, id);
        catalogue.editCampaign(description, startDate, endDate, coupon_id, id);
        return "Success";
    }

    public String editCoupon (int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        if (description.isEmpty() || startDate == null || endDate == null || discount < 0 || maxPrice <0 || minPrice < 0 || availableCoupons <=0) {
            return  "Please Fill the details correctly";
        }
        PersistanceHandlerController.getInstance().editCoupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
        catalogue.editCoupon(id, description, startDate, endDate, discount, minPrice, maxPrice, availableCoupons);
        return "Success";
    }

    public ArrayList<Coupon> getCoupons(){
        return catalogue.getCoupons();
    }

    public HashMap<Coupon, Event> getCouponMap(){
        return catalogue.getCouponMap();
    }

    public String requestSupport(String question, String topic, User user){
        if (question.isEmpty() || topic.isEmpty()){
            return "Please Fill All the Fields";
        }
        User supportPerson = null;
        for (User u : users){
            if (u.getRole().equals("Support Team")){
                supportPerson = u;
                break;
            }
        }
        if (supportPerson == null) {
            return "No Support Person Found. Please Try After Some Time";
        }
        int id = PersistanceHandlerController.getInstance().createSupportRequest(user.getId(), supportPerson.getId(), question, topic, LocalDateTime.now());
        supports.add(new RequestSupport(id, topic, question, new Date(System.currentTimeMillis()), user, supportPerson));
        return "Success";
    }

    public ArrayList<RequestSupport> getCustomerSupport(){
        ArrayList<RequestSupport> customerSupports = new ArrayList<>();
        for (RequestSupport rs : supports){
            if (rs.getCustomerId().getId() == getLoggedInUser().getId()){
                customerSupports.add(rs);
            }
        }
        return customerSupports;
    }

    public ArrayList<RequestSupport> getSupport(){
        return supports;
    }

    public ArrayList<RequestSupport> getSupportRequests(){
        ArrayList<RequestSupport> customerSupports = new ArrayList<>();
        for (RequestSupport rs : supports){
            if (rs.getSupportPersonId().getId() == getLoggedInUser().getId()){
                customerSupports.add(rs);
            }
        }
        return customerSupports;
    }

    public String sendMessage(String message, RequestSupport supportRequest){
        if (message.isEmpty()){
            return "Enter Message";
        }
        Date d = new Date(System.currentTimeMillis());
        System.out.println(supportRequest);
        System.out.println(supportRequest.messages);
        System.out.println(supportRequest);
        int id = PersistanceHandlerController.getInstance().sendMessage(message, d, getLoggedInUser().getId(), supportRequest.getId());
        supportRequest.sendMessage(getLoggedInUser(), message, d, id);
        return "Success";
    }

}
