package com.example.sdaproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class TicketBookingInfoPage{
    private Event event;

    public void setEvent(Event event) {
        this.event = event;
    }

    public void start(BorderPane primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(820.0, 550.0);
        root.setStyle("-fx-background-color: white;");

        Button backButton = new Button("< Back");
        backButton.setLayoutX(3.0);
        backButton.setLayoutY(4.0);
        backButton.setPrefSize(72.0, 27.0);
        backButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        backButton.setOnAction(e->{
            EventDetailsPage edp = new EventDetailsPage();
            edp.setEvent(event);
            edp.start(primaryStage);
        });

        Label titleLabel = new Label("Ticket Booking");
        titleLabel.setLayoutX(305.0);
        titleLabel.setLayoutY(17.0);
        titleLabel.setTextFill(javafx.scene.paint.Color.valueOf("#363e7c"));
        Font titleLabelFont = Font.font("System Bold Italic", 28.0);
        titleLabel.setFont(titleLabelFont);

        Pane eventPane = new Pane();
        eventPane.setLayoutX(174.0);
        eventPane.setLayoutY(74.99999999999997);
        eventPane.setPrefSize(471.0, 106.0);
        eventPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
        AnchorPane.setBottomAnchor(eventPane, 368.6);

        Label eventDetailsLabel = new Label("Event Details");
        eventDetailsLabel.setLayoutX(12.0);
        eventDetailsLabel.setLayoutY(7.0);
        eventDetailsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventDetailsFont = Font.font("System Bold Italic", 14.0);
        eventDetailsLabel.setFont(eventDetailsFont);

        Label eventDateLabel = new Label(event.getDate().toString());
        eventDateLabel.setLayoutX(14.0);
        eventDateLabel.setLayoutY(54.0);
        eventDateLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventDateFont = Font.font("System Italic", 14.0);
        eventDateLabel.setFont(eventDateFont);

        Label eventLabel = new Label(event.getLocation());
        eventLabel.setLayoutX(15.0);
        eventLabel.setLayoutY(74.0);
        eventLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventFont = Font.font("System Italic", 14.0);
        eventLabel.setFont(eventFont);

        Label concertLabel = new Label(event.getName());
        concertLabel.setLayoutX(14.0);
        concertLabel.setLayoutY(34.0);
        concertLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font concertFont = Font.font("System Italic", 14.0);
        concertLabel.setFont(concertFont);

        eventPane.getChildren().addAll(eventDetailsLabel, eventDateLabel, eventLabel, concertLabel);

        Button bookTicketsButton = new Button("Book Tickets");
        bookTicketsButton.setLayoutX(296.0);
        bookTicketsButton.setLayoutY(485.0);
        bookTicketsButton.setPrefSize(228.0, 40.0);
        bookTicketsButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        bookTicketsButton.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));


        Label priceLabel = new Label("0");
        priceLabel.setLayoutX(269.0);
        priceLabel.setLayoutY(435.0);
        priceLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font priceFont = Font.font("System Bold Italic", 24.0);
        priceLabel.setFont(priceFont);

        Label currencyLabel = new Label("PKR");
        currencyLabel.setLayoutX(244.0);
        currencyLabel.setLayoutY(441.0);
        currencyLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));

        Pane personalDetailsPane = new Pane();
        personalDetailsPane.setLayoutX(174.0);
        personalDetailsPane.setLayoutY(186.0);
        personalDetailsPane.setPrefSize(471.0, 154.0);
        personalDetailsPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label personalDetailsLabel = new Label("Personal Details");
        personalDetailsLabel.setLayoutX(12.0);
        personalDetailsLabel.setLayoutY(7.0);
        personalDetailsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font personalDetailsFont = Font.font("System Bold Italic", 14.0);
        personalDetailsLabel.setFont(personalDetailsFont);

        Label nameLabel = new Label("Name");
        nameLabel.setLayoutX(14.0);
        nameLabel.setLayoutY(41.0);
        nameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font nameFont = Font.font("System Italic", 14.0);
        nameLabel.setFont(nameFont);

        TextField nameTextField = new TextField();
        nameTextField.setLayoutX(94.0);
        nameTextField.setLayoutY(38.0);
        nameTextField.setPrefHeight(25.0);
        nameTextField.setPrefWidth(276.0);

        Label cnicLabel = new Label("CNIC");
        cnicLabel.setLayoutX(14.0);
        cnicLabel.setLayoutY(76.0);
        cnicLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font cnicFont = Font.font("System Italic", 14.0);
        cnicLabel.setFont(cnicFont);

        Label contactNoLabel = new Label("Contact No");
        contactNoLabel.setLayoutX(15.0);
        contactNoLabel.setLayoutY(108.0);
        contactNoLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font contactNoFont = Font.font("System Italic", 14.0);
        contactNoLabel.setFont(contactNoFont);

        TextField cnicTextField = new TextField();
        cnicTextField.setLayoutX(94.0);
        cnicTextField.setLayoutY(72.0);
        cnicTextField.setPrefHeight(25.0);
        cnicTextField.setPrefWidth(276.0);

        TextField contactNoTextField = new TextField();
        contactNoTextField.setLayoutX(94.0);
        contactNoTextField.setLayoutY(106.0);
        contactNoTextField.setPrefHeight(25.0);
        contactNoTextField.setPrefWidth(276.0);

        personalDetailsPane.getChildren().addAll(personalDetailsLabel, nameLabel, nameTextField, cnicLabel, contactNoLabel, cnicTextField, contactNoTextField);

        Pane ticketsPane = new Pane();
        ticketsPane.setLayoutX(174.0);
        ticketsPane.setLayoutY(345.0);
        ticketsPane.setPrefSize(471.0, 83.0);
        ticketsPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label ticketsLabel = new Label("Tickets");
        ticketsLabel.setLayoutX(12.0);
        ticketsLabel.setLayoutY(7.0);
        ticketsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font ticketsFont = Font.font("System Bold Italic", 14.0);
        ticketsLabel.setFont(ticketsFont);

        Label quantityLabel = new Label("Quantity");
        quantityLabel.setLayoutX(14.0);
        quantityLabel.setLayoutY(41.0);
        quantityLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font quantityFont = Font.font("System Italic", 14.0);
        quantityLabel.setFont(quantityFont);

        TextField quantitySpinner = new TextField();
        quantitySpinner.setLayoutX(98.0);
        quantitySpinner.setLayoutY(39.0);
        quantitySpinner.setPrefHeight(25.0);
        quantitySpinner.setPrefWidth(276.0);
        ticketsPane.getChildren().addAll(ticketsLabel, quantityLabel, quantitySpinner);
        quantitySpinner.setOnAction(e->{
            priceLabel.setText(Integer.toString(Integer.valueOf(quantitySpinner.getText()) * event.getPrice()));
        });

        Label totalLabel = new Label("Total");
        totalLabel.setLayoutX(191.0);
        totalLabel.setLayoutY(444.0);
        totalLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font totalFont = Font.font("System Bold Italic", 14.0);
        totalLabel.setFont(totalFont);

        bookTicketsButton.setOnAction(e->{
            if (nameTextField.getText().isEmpty() || cnicTextField.getText().isEmpty() || contactNoTextField.getText().isEmpty() || quantitySpinner.getText().isEmpty()){
                return;
            }
            PaymentPage pp = new PaymentPage();
            pp.setDetails(event, nameTextField.getText(), cnicTextField.getText(), contactNoTextField.getText(), Integer.valueOf(quantitySpinner.getText()));
            pp.start(primaryStage);
        });

        root.getChildren().addAll(backButton, titleLabel, eventPane, bookTicketsButton, priceLabel, currencyLabel,
                personalDetailsPane, ticketsPane, totalLabel);

        primaryStage.setCenter(root);
    }

}
