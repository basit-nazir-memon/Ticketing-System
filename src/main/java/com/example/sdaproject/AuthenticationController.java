package com.example.sdaproject;

public class AuthenticationController {
    private static AuthenticationController instance;
    private Authentication auth;
    private AuthenticationController() {
        auth = new Authentication();
    }

    public static AuthenticationController getInstance() {
        if (instance == null) {
            synchronized (AuthenticationController.class) {
                if (instance == null) {
                    instance = new AuthenticationController();
                }
            }
        }
        return instance;
    }

    public String login(String username, String password) {
        return auth.login(username, password);
    }

    public String getSecurityQuestion(String username) {
        return auth.getSecurityQuestion(username);
    }

    public String verifySecurityQuestion(String username, String answer) {
        return auth.verifySecurityQuestion(username, answer);
    }

    public String setPassword(String username, String password, String c_password){
        return auth.setPassword(username, password, c_password);
    }

    public String setNewPass(String username, String pass, String c_pass) {
        return auth.setNewPass(username, pass, c_pass);
    }
}