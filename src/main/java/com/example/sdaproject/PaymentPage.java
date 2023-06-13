package com.example.sdaproject;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.sql.Date;

public class PaymentPage{
    private Event event;
    private String name;
    private String cnic;
    private String contact;
    private int quantity;

    public void setDetails(Event event, String name, String cnic, String contact, int q) {
        this.event = event;
        this.name = name;
        this.cnic = cnic;
        this.contact = contact;
        this.quantity = q;
    }

    public void start(BorderPane primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(820.0, 550.0);
        root.setStyle("-fx-background-color: white;");

        Button backButton = new Button("< Back");
        backButton.setLayoutX(3.0);
        backButton.setLayoutY(4.0);
        backButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        backButton.setOnAction(e->{
            EventDetailsPage edp = new EventDetailsPage();
            edp.setEvent(event);
            edp.start(primaryStage);
        });

        Label paymentLabel = new Label("Payment");
        paymentLabel.setLayoutX(16.0);
        paymentLabel.setLayoutY(39.0);
        paymentLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        paymentLabel.setFont(Font.font("System Bold Italic",  FontWeight.BOLD, FontPosture.ITALIC, 28.0));

        Pane eventDetailsPane = new Pane();
        eventDetailsPane.setLayoutX(560.0);
        eventDetailsPane.setLayoutY(95.6);
        eventDetailsPane.setPrefWidth(228.0);
        eventDetailsPane.setPrefHeight(106.0);
        eventDetailsPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label eventDetailsLabel = new Label("Event Details");
        eventDetailsLabel.setLayoutX(12.0);
        eventDetailsLabel.setLayoutY(7.0);
        eventDetailsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventDetailsLabelFont = new Font("System Bold Italic",14.0);
        eventDetailsLabel.setFont(eventDetailsLabelFont);

        Label dateLabel = new Label(event.getDate().toString());
        dateLabel.setLayoutX(14.0);
        dateLabel.setLayoutY(54.0);
        dateLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font dateLabelFont = new Font("System Italic", 14.0);
        dateLabel.setFont(dateLabelFont);

        Label venueLabel = new Label(event.getLocation());
        venueLabel.setLayoutX(15.0);
        venueLabel.setLayoutY(74.0);
        venueLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font venueLabelFont = new Font("System Italic", 14.0);
        venueLabel.setFont(venueLabelFont);

        Label eventNameLabel = new Label(event.getName());
        eventNameLabel.setLayoutX(14.0);
        eventNameLabel.setLayoutY(34.0);
        eventNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventNameLabelFont = new Font("System Italic", 14.0);
        eventNameLabel.setFont(eventNameLabelFont);

        eventDetailsPane.getChildren().addAll(eventDetailsLabel, dateLabel, venueLabel, eventNameLabel);

        Pane otherDetailsPane = new Pane();
        otherDetailsPane.setLayoutX(559.0);
        otherDetailsPane.setLayoutY(209.0);
        otherDetailsPane.setPrefWidth(228.0);
        otherDetailsPane.setPrefHeight(184.0);
        otherDetailsPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label otherDetailsLabel = new Label("Other Details");
        otherDetailsLabel.setLayoutX(12.0);
        otherDetailsLabel.setLayoutY(7.0);
        otherDetailsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font otherDetailsLabelFont = new Font("System Bold Italic", 14.0);
        otherDetailsLabel.setFont(otherDetailsLabelFont);

        Label nameLabel1 = new Label("Name");
        nameLabel1.setLayoutX(14.0);
        nameLabel1.setLayoutY(41.0);
        nameLabel1.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font nameLabel1Font = new Font("System Italic", 14.0);
        nameLabel1.setFont(nameLabel1Font);

        Label cnicLabel1 = new Label("CNIC");
        cnicLabel1.setLayoutX(14.0);
        cnicLabel1.setLayoutY(76.0);
        cnicLabel1.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font cnicLabel1Font = new Font("System Italic", 14.0);
        cnicLabel1.setFont(cnicLabel1Font);

        Label contactNoLabel1 = new Label("Contact No");
        contactNoLabel1.setLayoutX(15.0);
        contactNoLabel1.setLayoutY(108.0);
        contactNoLabel1.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font contactNoLabel1Font = new Font("System Italic", 14.0);
        contactNoLabel1.setFont(contactNoLabel1Font);

        Label nameLabel2 = new Label(name);
        nameLabel2.setLayoutX(101.0);
        nameLabel2.setLayoutY(41.0);
        nameLabel2.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font nameLabel2Font = new Font("System Italic", 14.0);
        nameLabel2.setFont(nameLabel2Font);

        Label cnicLabel2 = new Label(cnic);
        cnicLabel2.setLayoutX(101.0);
        cnicLabel2.setLayoutY(76.0);
        cnicLabel2.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font cnicLabel2Font = new Font("System Italic", 14.0);
        cnicLabel2.setFont(cnicLabel2Font);

        Label contactNoLabel2 = new Label(contact);
        contactNoLabel2.setLayoutX(101.0);
        contactNoLabel2.setLayoutY(108.0);
        contactNoLabel2.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font contactNoLabel2Font = new Font("System Italic", 14.0);
        contactNoLabel2.setFont(contactNoLabel2Font);

        Label quantityLabel1 = new Label("Quantity");
        quantityLabel1.setLayoutX(16.0);
        quantityLabel1.setLayoutY(141.0);
        quantityLabel1.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font quantityLabel1Font = new Font("System Italic", 14.0);
        quantityLabel1.setFont(quantityLabel1Font);

        Label quantityLabel2 = new Label(Integer.toString(quantity));
        quantityLabel2.setLayoutX(99.0);
        quantityLabel2.setLayoutY(141.0);
        quantityLabel2.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font quantityLabel2Font = new Font("System Italic", 14.0);
        quantityLabel2.setFont(quantityLabel2Font);

        otherDetailsPane.getChildren().addAll(otherDetailsLabel, nameLabel1, cnicLabel1, contactNoLabel1, nameLabel2, cnicLabel2, contactNoLabel2, quantityLabel1, quantityLabel2);


        Button payButton = new Button("Pay Now");
        payButton.setLayoutX(559.0);
        payButton.setLayoutY(483.0);
        payButton.setPrefWidth(228);
        payButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        payButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        payButton.setFont(Font.font("System Bold", 14.0));

        payButton.setOnMouseEntered(e->{
            payButton.setStyle("-fx-background-color: #343e7c; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
            payButton.setTextFill(javafx.scene.paint.Color.web("#fff"));
        });

        payButton.setOnMouseExited(e->{
            payButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
            payButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        });



        Label totalLabel = new Label(Integer.toString(quantity * event.getPrice()));
        totalLabel.setLayoutX(732.0);
        totalLabel.setLayoutY(447.0);
        totalLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        totalLabel.setFont(Font.font("System Bold Italic", 24.0));

        Label pkrLabel = new Label("PKR");
        pkrLabel.setLayoutX(707.0);
        pkrLabel.setLayoutY(453.0);
        pkrLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

        Label totalTextLabel = new Label("Total");
        totalTextLabel.setLayoutX(654.0);
        totalTextLabel.setLayoutY(456.0);
        totalTextLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        totalTextLabel.setFont(Font.font("System Bold Italic", 14.0));

        Label selectPaymentLabel = new Label("Select Payment Method");
        selectPaymentLabel.setLayoutX(15.0);
        selectPaymentLabel.setLayoutY(91.0);
        selectPaymentLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        selectPaymentLabel.setFont(Font.font("System Bold Italic", 14.0));

        ComboBox<String> paymentComboBox = new ComboBox<>();
        paymentComboBox.setLayoutX(17.0);
        paymentComboBox.setLayoutY(113.0);
        paymentComboBox.setPrefSize(271.0, 27.0);
        paymentComboBox.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c;");

        paymentComboBox.getItems().addAll("Credit Card", "Debit Card", "Jazz Cash", "EasyPaisa", "SadaPay");

        Pane creditCardPane = new Pane();
        creditCardPane.setLayoutX(19.0);
        creditCardPane.setLayoutY(149.0);
        creditCardPane.setPrefSize(530.0, 245.0);
        creditCardPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label creditCardLabel = new Label(paymentComboBox.getValue());
        creditCardLabel.setLayoutX(12.0);
        creditCardLabel.setLayoutY(7.0);
        creditCardLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        creditCardLabel.setFont(Font.font("System Bold Italic", 18.0));

        paymentComboBox.setOnAction(event -> {
            creditCardPane.getChildren().clear();
            creditCardLabel.setText(paymentComboBox.getValue());
            if (paymentComboBox.getValue().equals("Credit Card") || paymentComboBox.getValue().equals("Debit Card")) {
                Label cardNumberLabel = new Label("Card Number");
                cardNumberLabel.setLayoutX(11.0);
                cardNumberLabel.setLayoutY(44.0);
                cardNumberLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
                cardNumberLabel.setFont(Font.font("System Italic", 14.0));

                TextField cardNumberTextField = new TextField();
                cardNumberTextField.setLayoutX(11.0);
                cardNumberTextField.setLayoutY(67.0);
                cardNumberTextField.setPrefSize(503.0, 25.0);
                cardNumberTextField.setPromptText("Enter Card Number");

                Label cvvLabel = new Label("CVV");
                cvvLabel.setLayoutX(11.0);
                cvvLabel.setLayoutY(157.0);
                cvvLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
                cvvLabel.setFont(Font.font("System Italic", 14.0));

                Label nameOnCardLabel = new Label("Name on Card");
                nameOnCardLabel.setLayoutX(11.0);
                nameOnCardLabel.setLayoutY(103.0);
                nameOnCardLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
                nameOnCardLabel.setFont(Font.font("System Italic", 14.0));

                TextField nameOnCardTextField = new TextField();
                nameOnCardTextField.setLayoutX(14.0);
                nameOnCardTextField.setLayoutY(123.0);
                nameOnCardTextField.setPrefSize(503.0, 25.0);
                nameOnCardTextField.setPromptText("Cardholder Name");

                TextField cvvTextField = new TextField();
                cvvTextField.setLayoutX(14.0);
                cvvTextField.setLayoutY(177.0);
                cvvTextField.setPrefSize(164.0, 25.0);
                cvvTextField.setPromptText("CVV");

                Label dateOfExpireLabel = new Label("Date of Expire");
                dateOfExpireLabel.setLayoutX(198.0);
                dateOfExpireLabel.setLayoutY(157.0);
                dateOfExpireLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
                dateOfExpireLabel.setFont(Font.font("System Italic", 14.0));

                DatePicker expireDatePicker = new DatePicker();
                expireDatePicker.setLayoutX(195.0);
                expireDatePicker.setLayoutY(177.0);
                expireDatePicker.setPrefSize(321.0, 25.0);
                expireDatePicker.setStyle("-fx-background-color: WHITE; -fx-border-color: LIGHTGRAY;");
                creditCardPane.getChildren().addAll(creditCardLabel, cardNumberLabel, cardNumberTextField,
                        cvvLabel, nameOnCardLabel, nameOnCardTextField, cvvTextField, dateOfExpireLabel, expireDatePicker);

                payButton.setOnAction(e->{
                    String response = SingletonTicketingSystemController.getInstance().puchaseTicket(this.event, name, cnic, contact, quantity, cardNumberTextField.getText(), nameOnCardTextField.getText(), cvvTextField.getText(), expireDatePicker.getValue() == null ? null : Date.valueOf(expireDatePicker.getValue()), creditCardLabel.getText());
                    if (response == "Available"){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Payment Successfull");
                        alert.setHeaderText("Success");
                        alert.setContentText("The payment for the event is successfull");
                        alert.showAndWait();
                        EventsPage ep = new EventsPage();
                        ep.start(primaryStage);
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Payment Unsuccessfull");
                        alert.setHeaderText("Error");
                        alert.setContentText(response);
                        alert.showAndWait();
                    }
                });
            }else {
                Label accountNumberLabel = new Label("Account Number");
                accountNumberLabel.setLayoutX(11.0);
                accountNumberLabel.setLayoutY(31.0);
                accountNumberLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
                accountNumberLabel.setFont(Font.font("System Italic", 14.0));

                TextField accountNumberTextField = new TextField();
                accountNumberTextField.setLayoutX(11.0);
                accountNumberTextField.setLayoutY(54.0);
                accountNumberTextField.setPrefSize(503.0, 25.0);
                accountNumberTextField.setPromptText("Enter Account Number");

                creditCardPane.getChildren().addAll(creditCardLabel, accountNumberLabel, accountNumberTextField);

                payButton.setOnAction(e->{
                    String response = SingletonTicketingSystemController.getInstance().puchaseTicket(this.event, name, cnic, contact, quantity, accountNumberTextField.getText(), creditCardLabel.getText());
                    if (response == "Available"){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Payment Successfull");
                        alert.setHeaderText("Success");
                        alert.setContentText("The payment for the event is successfull");
                        alert.showAndWait();
                        EventsPage ep = new EventsPage();
                        ep.start(primaryStage);
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Payment Unsuccessfull");
                        alert.setHeaderText("Error");
                        alert.setContentText(response);
                        alert.showAndWait();
                    }
                });
            }
        });



        root.getChildren().addAll(backButton, paymentLabel, payButton, totalLabel, pkrLabel, totalTextLabel,
                selectPaymentLabel, paymentComboBox, creditCardPane, eventDetailsPane, otherDetailsPane);

        primaryStage.setCenter(root);
    }
}
