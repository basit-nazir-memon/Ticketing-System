package com.example.sdaproject;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

public class EditCampaignPage {

    Event event;

    Campaign cam;

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setCam(Campaign cam) {
        this.cam = cam;
    }

    public void start(BorderPane primaryStage) {

        File file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(820.0, 550.0);
        anchorPane.setStyle("-fx-background-color: white;");

        Label titleLabel = new Label("Edit Campaign");
        titleLabel.setLayoutX(11.0);
        titleLabel.setLayoutY(6.0);
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        titleLabel.setFont(Font.font("System Bold Italic", 28.0));

        ImageView imageView = new ImageView();
        imageView.setFitWidth(790.0);
        imageView.setFitHeight(150.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(46.0);
        imageView.setPreserveRatio(false);
        imageView.setImage(back);

        Label descriptionLabel = new Label("Description");
        descriptionLabel.setLayoutX(18.0);
        descriptionLabel.setLayoutY(209.0);
        descriptionLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        descriptionLabel.setFont(Font.font("System Bold", 14.0));

        Label endDateLabel = new Label("End Date");
        endDateLabel.setLayoutX(18.0);
        endDateLabel.setLayoutY(356.0);
        endDateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        endDateLabel.setFont(Font.font("System Bold", 14.0));

        Label startDateLabel = new Label("Start Date");
        startDateLabel.setLayoutX(18.0);
        startDateLabel.setLayoutY(310.0);
        startDateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        startDateLabel.setFont(Font.font("System Bold", 14.0));

        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setLayoutX(106.0);
        descriptionTextArea.setLayoutY(212.0);
        descriptionTextArea.setPrefHeight(75.0);
        descriptionTextArea.setPrefWidth(696.0);
        descriptionTextArea.setText(cam.getDescription());

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(106.0);
        startDatePicker.setLayoutY(307.0);
        startDatePicker.setPrefHeight(27.0);
        startDatePicker.setPrefWidth(284.0);
        startDatePicker.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        startDatePicker.setValue(cam.getStartDate().toLocalDate());

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(106.0);
        endDatePicker.setLayoutY(352.0);
        endDatePicker.setPrefHeight(27.0);
        endDatePicker.setPrefWidth(284.0);
        endDatePicker.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        endDatePicker.setValue(cam.getEndDate().toLocalDate());

        Label couponLabel = new Label("Coupon");
        couponLabel.setLayoutX(19.0);
        couponLabel.setLayoutY(398.0);
        couponLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        couponLabel.setFont(Font.font("System Bold", 14.0));

        ComboBox<String> couponComboBox = new ComboBox<>();
        couponComboBox.setLayoutX(106.0);
        couponComboBox.setLayoutY(394.0);
        couponComboBox.setPrefHeight(26.0);
        couponComboBox.setPrefWidth(284.0);
        couponComboBox.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        for (Coupon c: event.getCoupons()){
            couponComboBox.getItems().add(c.getCode());
        }
        couponComboBox.setValue(cam.getCoupon().getCode());

        Button createCampaignButton = new Button("Update Campaign");
        createCampaignButton.setLayoutX(608.0);
        createCampaignButton.setLayoutY(485.0);
        createCampaignButton.setPrefHeight(40.0);
        createCampaignButton.setPrefWidth(189.0);
        createCampaignButton.setStyle("-fx-background-color: #ed7d29; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        createCampaignButton.setTextFill(javafx.scene.paint.Color.WHITE);
        createCampaignButton.setFont(Font.font("System Bold", 14.0));

        Label errorLabel = new Label("Error - Error");
        errorLabel.setLayoutX(17.0);
        errorLabel.setLayoutY(451.0);
        errorLabel.setTextFill(javafx.scene.paint.Color.RED);
        errorLabel.setFont(Font.font("System Bold", 14.0));

        Button cancelButton = new Button("Close Campaign");
        cancelButton.setLayoutX(456.0);
        cancelButton.setLayoutY(485.0);
        cancelButton.setPrefHeight(40.0);
        cancelButton.setPrefWidth(144.0);
        cancelButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
        cancelButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        cancelButton.setFont(Font.font("System Bold", 14.0));
        errorLabel.setVisible(false);
        cancelButton.setOnAction(e->{
            SingletonTicketingSystemController.getInstance().deleteCampaign(cam.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Campaign Deleted");
            alert.setContentText("The Campaign has been deleted Successfully");
            alert.showAndWait();
            CampaignsPage cp = new CampaignsPage();
            cp.start(primaryStage);
        });

        createCampaignButton.setOnAction(e->{
            Coupon coupon = null;
            for (Coupon c: event.getCoupons()){
                if (couponComboBox.getValue().equals(c.getCode())){
                    coupon = c;
                    break;
                }
            }
            String response = SingletonTicketingSystemController.getInstance().editCampaign(cam.getId(), descriptionTextArea.getText(), startDatePicker.getValue() == null? null : Date.valueOf(startDatePicker.getValue()), endDatePicker.getValue() == null?null:Date.valueOf(endDatePicker.getValue()), coupon.getId());
            errorLabel.setText(response);
            if (response.equals("Success")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Campaign Updated");
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
                imageView,
                descriptionLabel,
                endDateLabel,
                startDateLabel,
                descriptionTextArea,
                startDatePicker,
                endDatePicker,
                couponLabel,
                couponComboBox,
                createCampaignButton,
                errorLabel,
                cancelButton
        );
        primaryStage.setCenter(anchorPane);
    }

}
