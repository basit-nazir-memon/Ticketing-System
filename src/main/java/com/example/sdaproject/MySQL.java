package com.example.sdaproject;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MySQL implements PersistanceHandler  {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sdaProject";
    static final String USER = "root";
    static final String PASS = "123009111";
    private Connection conn = null;
    private Statement stmt = null;

    public MySQL(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Execute a query to create student table
            System.out.println("Creating student table...");
            stmt = conn.createStatement();
            String createStudentTable = "CREATE TABLE student " +
                    "(student_id INT NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " cgpa FLOAT, " +
                    " sgpa FLOAT, " +
                    " age INT, " +
                    " PRIMARY KEY ( student_id ))";
            stmt.executeUpdate(createStudentTable);

            // Insert 3 to 4 records in student table


            // Print all those students whose age is less
            // than 20 years
//            System.out.println("Printing students whose age is less than 20 years...");
//            String selectYoungStudents = "SELECT * FROM student WHERE age < 20";
//            ResultSet youngStudents = stmt.executeQuery(selectYoungStudents);
//            while (youngStudents.next()) {
//                int id = youngStudents.getInt("student_id");
//                String name = youngStudents.getString("name");
//                String email = youngStudents.getString("email");
//                float cgpa = youngStudents.getFloat("cgpa");
//                float sgpa = youngStudents.getFloat("sgpa");
//                int age = youngStudents.getInt("age");
//                System.out.println(id + ", " + name + ", " + email + ", " + cgpa + ", " + sgpa + ", " + age);
//            }

            // Close resources
//            youngStudents.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public int registerUser(String firstName, String lastName, String email, String usename, String password, String gender, String question, String answer, Date dob, boolean tnc, String role){
        try {
            String createUser = "INSERT INTO User (first_name, last_name, username, password, role, dob, email, gender, tAndC, isActive) VALUES ('" + firstName +"','" + lastName +"','" + usename +"','" + password+"','" + role +"','" + dob +"','" + email +"','" + gender+"'," + tnc + ",true)";
            stmt.executeUpdate(createUser);
            String getUserId = "SELECT id FROM User where username = '" + usename+"'";
            ResultSet rs = stmt.executeQuery(getUserId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            String createUserAccount = "INSERT INTO UserAccount (security_question, answer, user_id) VALUES ('" + question +"','" + answer +"',"+id+")";
            stmt.executeUpdate(createUserAccount);
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String setPassword(String username, String password){
        try {
            String selectUsers = "UPDATE User SET password = '" + password +"' WHERE username = '" + username + "'";
            stmt.executeUpdate(selectUsers);
            return "Updated";
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: No User having 'username : " + username + "' Exist";
    }
    @Override
    public String getSecurityAnswer(String username){
        try {
            String selectUsers = "SELECT answer FROM UserAccount ua INNER JOIN User u ON u.id = ua.user_id WHERE u.username = '" + username + "'";
            ResultSet users = stmt.executeQuery(selectUsers);
            users.next();
            String answer = users.getString("answer");
            users.close();
            return answer;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: No User having 'username : " + username + "' Exist";
    }

    @Override
    public String getSecurityQuestion(String username) {
        try {
            String selectUsers = "SELECT security_question FROM UserAccount ua INNER JOIN User u ON u.id = ua.user_id WHERE u.username = '" + username + "'";
            ResultSet users = stmt.executeQuery(selectUsers);
            users.next();
            String question = users.getString("security_question");
            users.close();
            return question;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error: No User having 'username : " + username + "' Exist";
    }

    @Override
    public void loadUsers(ArrayList<User> usersList) {
        try {
            String selectUsers = "SELECT * FROM User";
            ResultSet users = stmt.executeQuery(selectUsers);
            while (users.next()) {
                int id = users.getInt("id");
                String firstName = users.getString("first_name");
                String lastName = users.getString("last_name");
                String userName = users.getString("username");
                String pass = users.getString("password");
                String role = users.getString("role");
                Date dob = users.getDate("dob");
                String email = users.getString("email");
                String gender = users.getString("gender");
                boolean tnc = users.getBoolean("tAndC");
                boolean isActive = users.getBoolean("isActive");
                usersList.add(new User(id,firstName,lastName, userName, pass, role, dob, email, gender, tnc, isActive));
            }
            users.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void loadSupports(ArrayList<RequestSupport> supports, ArrayList<User> usersList){
        try {
            String selectUsers = "SELECT * FROM SupportTable";
            ResultSet users = stmt.executeQuery(selectUsers);
            while (users.next()) {
                int id = users.getInt("id");
                String question = users.getString("question");
                String topic = users.getString("questionTopic");
                Date date = users.getDate("dateTime");
                int cus_Id = users.getInt("customerId");
                int sp_Id = users.getInt("supportPersonId");

                User cus = null;
                User sp = null;

                for (User u:usersList){
                    if (u.getId() == cus_Id){
                        cus = u;
                    }
                    if (u.getId() == sp_Id){
                        sp = u;
                    }
                }
                RequestSupport rs = new RequestSupport();
                rs.update(id, topic, question, date, cus, sp);
                supports.add(rs);
            }
            users.close();

            selectUsers = "SELECT * FROM Messages";
            users = stmt.executeQuery(selectUsers);
            while (users.next()) {
                int id = users.getInt("id");
                String message = users.getString("message");
                Date date = users.getDate("dateTime");
                int cus_Id = users.getInt("userId");
                int sp_Id = users.getInt("supportTableId");

                User cus = null;

                for (User u:usersList){
                    if (u.getId() == cus_Id){
                        cus = u;
                        break;
                    }
                }
                for (RequestSupport rs: supports) {
                    if (rs.getId() == sp_Id) {
                        rs.sendMessage(cus, message, date, id);
                        break;
                    }
                }
            }
            users.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void loadEvents(ArrayList<Event> eventsList) {
        try {
            String selectEvents = "SELECT * FROM Events";
            ResultSet events = stmt.executeQuery(selectEvents);
            while (events.next()) {
                int id = events.getInt("id");
                String Name = events.getString("name");
                Date date = events.getDate("date");
                Time time = events.getTime("time");
                String loc = events.getString("location");
                String desc = events.getString("description");
                String pic = events.getString("picture");
                int noOfTickets = events.getInt("numberOfTickets");
                int price = events.getInt("price");
                int user_id = events.getInt("user_id");
                eventsList.add(new Event(id, Name,date,time, loc, desc, pic, noOfTickets, price, user_id));
            }
            events.close();

            selectEvents = "SELECT * FROM Coupons";
            events = stmt.executeQuery(selectEvents);
            while (events.next()) {
                int id = events.getInt("id");
                String description = events.getString("description");
                Date startDate = events.getDate("start_date");
                Date endDate = events.getDate("end_date");
                int event_id = events.getInt("event_id");
                String code = events.getString("code");
                double dicount = events.getDouble("discount");
                double min_price = events.getDouble("min_price");
                double max_price = events.getDouble("max_price");
                int availableCoupons = events.getInt("available_coupons");
                for (Event e: eventsList){
                    if (e.getId() == event_id){
                        e.createCoupon(id, description, startDate, endDate, dicount, min_price, max_price, availableCoupons, code);
                        break;
                    }
                }
            }
            events.close();
            selectEvents = "SELECT * FROM Campaigns";
            events = stmt.executeQuery(selectEvents);
            while (events.next()) {
                int id = events.getInt("id");
                String pic = events.getString("picture");
                String description = events.getString("description");
                Date startDate = events.getDate("start_date");
                Date endDate = events.getDate("end_date");
                int event_id = events.getInt("event_id");
                int coupon_id = events.getInt("coupon_id");
                String plan = events.getString("plan");
                for (Event e: eventsList){
                    if (e.getId() == event_id){
                        for (Coupon cup: e.getCoupons()){
                            if (cup.getId() == coupon_id){
                                e.createCampaign(id, pic, description, startDate, endDate, e, plan, cup);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            events.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteCampaign(int CampaignId){
        try {
            String deleteCampaign = "DELETE FROM Campaigns WHERE id = " + CampaignId;
            stmt.executeUpdate(deleteCampaign);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void addReservation(Event e, String name, String cnic, String contact, int quantity, String carNumber, String nameOnCard, String CVV, Date doe, String type){
        try {
            String getUserId = "SELECT id FROM Events where name = '" + e.getName() +"'";
            ResultSet rs = stmt.executeQuery(getUserId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            String createUser = "INSERT INTO Reservation (event_id, user_id, name, cnic, contact, quantity, cardNumber, nameOnCard, cvv, doe, type) VALUES (" + id +"," + SingletonTicketingSystemController.getInstance().getLoggedInUser().getId() +",'" + name +"','" + cnic+"','" + contact +"'," + quantity +",'" + carNumber +"','" + nameOnCard +"','" + CVV+"','" + doe +"','" + type + "')";
            stmt.executeUpdate(createUser);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void loadReservations(ArrayList<Reservation> reservationsList, ArrayList<User>users, EventCatalogue catalogue ){
        System.out.println("Hey");
        try {
            System.out.println("Hellp");
            String selectEvents = "SELECT * FROM Reservation";
            System.out.println("Hep");
            ResultSet events = stmt.executeQuery(selectEvents);
            System.out.println("Heodkd");
            while (events.next()) {
                int event_id = events.getInt("event_id");
                int user_id = events.getInt("user_id");
                String name = events.getString("name");
                String cnic = events.getString("cnic");
                String contact = events.getString("contact");
                int quantity = events.getInt("quantity");
                String cardNum = events.getNString("cardNumber");
                String nameOnCard = events.getNString("nameOnCard");
                String cvv = events.getNString("cvv");
                Date doe = events.getDate("doe");
                String type = events.getString("type");

                User u = null;
                Event e;
                for (User user: users){
                    if (user.getId() == user_id){
                        u = user;
                    }
                }
                e = catalogue.getEvent(event_id);
                System.out.println("entered ");

                System.out.println(SingletonBankingSystem.getInstance().checkAmount(cardNum, nameOnCard, cvv, doe, quantity*e.getPrice()));
                System.out.println("entered left");
                Reservation rev = new Reservation(u, e);
                rev.ReservationLoad(name, cnic, contact, quantity, cardNum, nameOnCard, cvv, doe, type);
                reservationsList.add(rev);
            }
            events.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int createEvent(String name, String location, Date date, int noOfTickets, int Price, String Desciption){
       try {
            String createEvent = "INSERT INTO Events (name, date, time, location, description, picture, numberOfTickets, price, user_id) VALUES ('" + name +"','" + date +"',null,'" + location+"','" + Desciption +"',null," + noOfTickets +"," + Price+"," + SessionStorage.getInstance().getUser().getId() + ")";
            stmt.executeUpdate(createEvent);
            String getEventId = "SELECT id FROM Events where name = '" + name+"' AND description = '" + Desciption + "'";
            ResultSet rs = stmt.executeQuery(getEventId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int createCoupon (int Eventid, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons, String code) {
        try {
            String createEvent = "INSERT INTO coupons (description, start_date, end_date, event_id, discount, min_price, max_price, available_coupons, code) VALUES ('" + description +"','" + startDate +"','" + endDate+"'," + Eventid +"," + discount +"," + minPrice+"," + maxPrice + "," + availableCoupons + ",'" + code + "')";
            stmt.executeUpdate(createEvent);
            String getEventId = "SELECT id FROM coupons where start_date = '" + startDate+"' AND description = '" + description + "'";
            ResultSet rs = stmt.executeQuery(getEventId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            System.out.println(id);
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int createCampaign (String picture, String description, Date startDate, Date endDate, int event_id, String plan, int coupon_id) {
        try {
            System.out.println(coupon_id);
            System.out.println(event_id);
            String createEvent = "INSERT INTO campaigns (picture, description, start_date, end_date, event_id, plan, coupon_id) VALUES ('" + picture + "','" + description +"','" + startDate +"','" + endDate+"'," + event_id +",'" + plan +"'," + coupon_id+")";
            stmt.executeUpdate(createEvent);
            String getEventId = "SELECT id FROM campaigns where start_date = '" + startDate+"' AND description = '" + description + "'";
            ResultSet rs = stmt.executeQuery(getEventId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void editCampaign (String description, Date startDate, Date endDate, int coupon_id, int campaignId) {
        try {
            String createEvent = "UPDATE campaigns SET description = ?, start_date = ?, end_date = ?, coupon_id = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(createEvent);
            statement.setString(1, description);
            statement.setDate(2, startDate);
            statement.setDate(3, endDate);
            statement.setInt(4, coupon_id);
            statement.setInt(5, campaignId);
            statement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCoupon (int id, String description, Date startDate, Date endDate, double discount, double minPrice, double maxPrice, int availableCoupons) {
        try {
            String createEvent = "UPDATE Coupons SET description = ?, start_date = ?, end_date = ?, discount=?, min_price = ?, max_price = ?, available_coupons = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(createEvent);
            statement.setString(1, description);
            statement.setDate(2, startDate);
            statement.setDate(3, endDate);
            statement.setDouble(4, discount);
            statement.setDouble(5, minPrice);
            statement.setDouble(6, maxPrice);
            statement.setInt(7, availableCoupons);
            statement.setInt(8, id);
            statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int createSupportRequest(int userId, int SupportPersonId, String question, String questionTopic, LocalDateTime dateTime){
        try {
            Date currentDate = new Date(System.currentTimeMillis());
            String createEvent = "INSERT INTO SupportTable (question, questionTopic, dateTime, customerId, supportPersonId) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(createEvent);
            statement.setString(1, question);
            statement.setString(2, questionTopic);
            statement.setDate(3, currentDate);
            statement.setInt(4, userId);
            statement.setInt(5, SupportPersonId);
            statement.executeUpdate();
            String getEventId = "SELECT id FROM SupportTable where question = '" + question+"' AND questionTopic = '" + questionTopic + "'";
            ResultSet rs = stmt.executeQuery(getEventId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            createEvent = "INSERT INTO Messages (message, dateTime, userId, supportTableId) VALUES (?,?,?,?)";
            statement = conn.prepareStatement(createEvent);
            statement.setString(1, question);
            statement.setDate(2, currentDate);
            statement.setInt(3, userId);
            statement.setInt(4, id);
            statement.executeUpdate();
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int sendMessage(String message, Date date, int userId, int supportRequestId){
        try {
            String createEvent = "INSERT INTO Messages (message, dateTime, userId, supportTableId) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(createEvent);
            statement.setString(1, message);
            statement.setDate(2, date);
            statement.setInt(3, userId);
            statement.setInt(4, supportRequestId);
            statement.executeUpdate();
            String getEventId = "SELECT id FROM Messages where message = '" + message+"' AND dateTime = '" + date + "'";
            ResultSet rs = stmt.executeQuery(getEventId);
            rs.next();
            int id = rs.getInt("id");
            rs.close();
            return id;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
