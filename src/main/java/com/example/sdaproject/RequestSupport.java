package com.example.sdaproject;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RequestSupport {
    private int id;
    private String questionTopic;
    private String question;
    private Date dateTime;
    private User customer;
    private User supportPerson;
    ArrayList<Message> messages;
    // Constructor

    public RequestSupport() {
        this.id = 0;
        this.questionTopic = null;
        this.question = null;
        this.dateTime = null;
        this.customer = null;
        this.supportPerson = null;
        messages = new ArrayList<>();
    }

    public void update(int id, String questionTopic, String question, Date dateTime, User customer, User supportPerson) {
        this.id = id;
        this.questionTopic = questionTopic;
        this.question = question;
        this.dateTime = dateTime;
        this.customer = customer;
        this.supportPerson = supportPerson;
    }

    public RequestSupport(int id, String questionTopic, String question, Date dateTime, User customer, User supportPerson) {
        this.id = id;
        this.questionTopic = questionTopic;
        this.question = question;
        this.dateTime = dateTime;
        this.customer = customer;
        this.supportPerson = supportPerson;
        messages = new ArrayList<>();
        messages.add(new Message(question, dateTime, customer, id));
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic) {
        this.questionTopic = questionTopic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public User getCustomerId() {
        return customer;
    }

    public void setCustomerId(User customerId) {
        this.customer = customerId;
    }

    public User getSupportPersonId() {
        return supportPerson;
    }

    public void setSupportPersonId(User supportPersonId) {
        this.supportPerson = supportPersonId;
    }

    public void sendMessage(User from, String text, Date dateTime, int id){
        messages.add(new Message(text, dateTime, from, id));
    }
}
