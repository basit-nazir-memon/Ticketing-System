package com.example.sdaproject;


public class Authentication {
    public Authentication(){

    }
    public String login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return "Please provide both username and password.";
        }
        SingletonTicketingSystem ticketingSystem = SingletonTicketingSystem.getInstance();
        for (User user : ticketingSystem.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                SessionStorage sessionStorage = SessionStorage.getInstance();
                sessionStorage.setSession(user);
                return user.getRole();
            }
        }
        return "Invalid Username / Password";
    }
    public String getSecurityQuestion(String username) {
        if (username.isEmpty()){
            return "Error: Enter Username";
        }
        return PersistanceHandlerController.getInstance().getSecurityQuestion(username);
    }

    public String setPassword(String username, String password, String c_password){
        if (password.isEmpty()){
            return "Enter Password to Continue";
        }
        if (password.equals(c_password)){
            return PersistanceHandlerController.getInstance().setPassword(username, password);
        }
        return "Password and Confirm Password Must Match";
    }


    public String verifySecurityQuestion(String username, String answer) {
        if (username.isEmpty() || answer.isEmpty()) {
            return "Please provide security answer";
        }
        String Ans = PersistanceHandlerController.getInstance().getSecurityAnswer(username);
        if (Ans.isEmpty()){
            return "No Answer Found";
        }
        if (Ans.equals(answer)){
            return "Verified";
        }
        return "Not Verified";
    }
    public String setNewPass(String username, String pass, String c_pass) {
        if (username.isEmpty() || pass.isEmpty()) {
            return "Please provide both username and password.";
        }
        if (!pass.equals(c_pass)){
            return "Password & Conform password must match.";
        }
        SingletonTicketingSystem ticketingSystem = SingletonTicketingSystem.getInstance();
        for (User user : ticketingSystem.users) {
            if (user.getUsername().equals(username)){
                user.setPassword(pass);
                return "Success";
            }
        }
        return "Invalid Username";
    }
}
