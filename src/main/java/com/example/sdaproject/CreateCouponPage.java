package com.example.sdaproject;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.sql.Date;
import java.util.ArrayList;

public class CreateCouponPage{
    ArrayList<Event> events;

    public void start(BorderPane primaryStage) {
        events = SingletonTicketingSystemController.getInstance().getEvents();

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setMaxHeight(Double.NEGATIVE_INFINITY);
        anchorPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        anchorPane.setMinHeight(Double.NEGATIVE_INFINITY);
        anchorPane.setMinWidth(Double.NEGATIVE_INFINITY);
        anchorPane.setPrefHeight(550.0);
        anchorPane.setPrefWidth(820.0);
        anchorPane.setStyle("-fx-background-color: white;");
        Label titleLabel = new Label("Create Coupon");
        titleLabel.setLayoutX(11.0);
        titleLabel.setLayoutY(6.0);
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        titleLabel.setFont(Font.font("System Bold Italic", 28.0));

        Label descriptionLabel = new Label("Description");
        descriptionLabel.setLayoutX(18.0);
        descriptionLabel.setLayoutY(106.0);
        descriptionLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        descriptionLabel.setFont(Font.font("System Bold", 14.0));

        Label endDateLabel = new Label("End Date");
        endDateLabel.setLayoutX(437.0);
        endDateLabel.setLayoutY(201.0);
        endDateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        endDateLabel.setFont(Font.font("System Bold", 14.0));

        Label startDateLabel = new Label("Start Date");
        startDateLabel.setLayoutX(19.0);
        startDateLabel.setLayoutY(201.0);
        startDateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        startDateLabel.setFont(Font.font("System Bold", 14.0));

        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setLayoutX(106.0);
        descriptionTextArea.setLayoutY(108.0);
        descriptionTextArea.setPrefHeight(75.0);
        descriptionTextArea.setPrefWidth(696.0);

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(107.0);
        startDatePicker.setLayoutY(198.0);
        startDatePicker.setPrefHeight(27.0);
        startDatePicker.setPrefWidth(284.0);
        startDatePicker.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(518.0);
        endDatePicker.setLayoutY(197.0);
        endDatePicker.setPrefHeight(27.0);
        endDatePicker.setPrefWidth(284.0);
        endDatePicker.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        Label eventLabel = new Label("Event");
        eventLabel.setLayoutX(19.0);
        eventLabel.setLayoutY(70.0);
        eventLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        eventLabel.setFont(Font.font("System Bold", 14.0));

        Label discountLabel = new Label("Discount");
        discountLabel.setLayoutX(17.0);
        discountLabel.setLayoutY(245.0);
        discountLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        discountLabel.setFont(Font.font("System Bold", 14.0));

        ComboBox<String> eventComboBox = new ComboBox<>();
        eventComboBox.setLayoutX(106.0);
        eventComboBox.setLayoutY(66.0);
        eventComboBox.setPrefHeight(26.0);
        eventComboBox.setPrefWidth(284.0);
        eventComboBox.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        for (Event e : events){
            eventComboBox.getItems().add(e.getName());
        }


        ComboBox<String> discountComboBox = new ComboBox<>();
        discountComboBox.setLayoutX(105.0);
        discountComboBox.setLayoutY(241.0);
        discountComboBox.setPrefHeight(26.0);
        discountComboBox.setPrefWidth(284.0);
        discountComboBox.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        discountComboBox.getItems().addAll("2", "5", "10", "15", "20", "25", "30","35", "40", "45", "50");


        Label minPriceLabel = new Label("Min Price");
        minPriceLabel.setLayoutX(19.0);
        minPriceLabel.setLayoutY(289.0);
        minPriceLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        minPriceLabel.setFont(Font.font("System Bold", 14.0));

        Button createCouponButton = new Button("Create Coupon");
        createCouponButton.setLayoutX(608.0);
        createCouponButton.setLayoutY(485.0);
        createCouponButton.setMnemonicParsing(false);
        createCouponButton.setPrefHeight(40.0);
        createCouponButton.setPrefWidth(189.0);
        createCouponButton.setStyle("-fx-background-color: #ed7d29; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        createCouponButton.setTextFill(javafx.scene.paint.Color.WHITE);
        createCouponButton.setFont(Font.font("System Bold", 14.0));

        Label errorLabel = new Label("Error - Error");
        errorLabel.setLayoutX(17.0);
        errorLabel.setLayoutY(451.0);
        errorLabel.setTextFill(javafx.scene.paint.Color.RED);
        errorLabel.setFont(Font.font("System Bold", 14.0));
        errorLabel.setVisible(false);

        Button cancelButton = new Button("Cancel");
        cancelButton.setLayoutX(456.0);
        cancelButton.setLayoutY(485.0);
        cancelButton.setMnemonicParsing(false);
        cancelButton.setPrefHeight(40.0);
        cancelButton.setPrefWidth(144.0);
        cancelButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
        cancelButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        cancelButton.setFont(Font.font("System Bold", 14.0));

        Label maxDiscountLabel = new Label("Max Discount Price");
        maxDiscountLabel.setLayoutX(19.0);
        maxDiscountLabel.setLayoutY(332.0);
        maxDiscountLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        maxDiscountLabel.setFont(Font.font("System Bold", 14.0));

        TextField minPriceSpinner = new TextField();
        minPriceSpinner.setLayoutX(105.0);
        minPriceSpinner.setLayoutY(286.0);
        minPriceSpinner.setPrefHeight(27.0);
        minPriceSpinner.setPrefWidth(284.0);
        minPriceSpinner.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        TextField maxDiscountSpinner = new TextField();
        maxDiscountSpinner.setLayoutX(170.0);
        maxDiscountSpinner.setLayoutY(328.0);
        maxDiscountSpinner.setPrefHeight(27.0);
        maxDiscountSpinner.setPrefWidth(284.0);
        maxDiscountSpinner.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        Label availableCouponsLabel = new Label("Available Coupons");
        availableCouponsLabel.setLayoutX(20.0);
        availableCouponsLabel.setLayoutY(377.0);
        availableCouponsLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        availableCouponsLabel.setFont(Font.font("System Bold", 14.0));

        TextField availableCouponsSpinner = new TextField();
        availableCouponsSpinner.setLayoutX(170.0);
        availableCouponsSpinner.setLayoutY(373.0);
        availableCouponsSpinner.setPrefHeight(27.0);
        availableCouponsSpinner.setPrefWidth(284.0);
        availableCouponsSpinner.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        createCouponButton.setOnAction(e->{
            Event event = null;
            for (Event ev: events){
                if (eventComboBox.getValue().equals(ev.getName())){
                    event = ev;
                    break;
                }
            }
            String response = SingletonTicketingSystemController.getInstance().createCoupon(event, descriptionTextArea.getText(), startDatePicker.getValue()==null?null: Date.valueOf(startDatePicker.getValue()), endDatePicker.getValue()==null?null:Date.valueOf(endDatePicker.getValue()), discountComboBox.getValue()==null?0:Double.valueOf(discountComboBox.getValue()), minPriceSpinner.getText() == null ? 0 : Double.valueOf(minPriceSpinner.getText()) , maxDiscountSpinner.getText() == null ? 0 : Double.valueOf(maxDiscountSpinner.getText()), Integer.valueOf(availableCouponsSpinner.getText()));
            errorLabel.setText(response);
            if (response.equals("Coupon created successfully.")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Coupon Created");
                alert.setContentText(response);
                alert.showAndWait();
                CampaignsMain cm = new CampaignsMain();
                cm.start(primaryStage);
            }else{
                errorLabel.setVisible(true);
            }
        });

        anchorPane.getChildren().addAll(
                titleLabel,
                descriptionLabel,
                endDateLabel,
                startDateLabel,
                descriptionTextArea,
                startDatePicker,
                endDatePicker,
                eventLabel,
                discountLabel,
                eventComboBox,
                discountComboBox,
                minPriceLabel,
                createCouponButton,
                errorLabel,
                cancelButton,
                maxDiscountLabel,
                minPriceSpinner,
                maxDiscountSpinner,
                availableCouponsLabel,
                availableCouponsSpinner
        );
        primaryStage.setCenter(anchorPane);

    }

}