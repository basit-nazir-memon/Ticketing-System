package com.example.sdaproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class CampaignInfo{
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

        Label titleLabel = new Label(event.getName() + " Campaign");
        titleLabel.setLayoutX(11.0);
        titleLabel.setLayoutY(6.0);
        titleLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        titleLabel.setFont(Font.font("System Bold Italic", 28.0));

        Button closeButton = new Button("Close Campaign");
        closeButton.setLayoutX(14.0);
        closeButton.setLayoutY(489.0);
        closeButton.setPrefSize(390.0, 46.0);
        closeButton.setStyle("-fx-background-color: #ed7d29; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        closeButton.setTextFill(javafx.scene.paint.Color.WHITE);
        closeButton.setFont(Font.font("System Bold", 14.0));
        closeButton.setOnAction(e->{
            if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Customer")){
                CampaignsPage cp = new CampaignsPage();
                cp.start(primaryStage);
            }
            else{
                SingletonTicketingSystemController.getInstance().deleteCampaign(cam.getId());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Campaign Deleted");
                alert.setContentText("The Campaign has been deleted Successfully");
                alert.showAndWait();
                CampaignsPage cp = new CampaignsPage();
                cp.start(primaryStage);
            }
        });

        Button editButton = new Button("Edit Campaign");
        editButton.setLayoutX(415.0);
        editButton.setLayoutY(489.0);
        editButton.setPrefSize(390.0, 46.0);
        editButton.setStyle("-fx-background-color: #343e7c; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        editButton.setTextFill(javafx.scene.paint.Color.WHITE);
        editButton.setFont(Font.font("System Bold", 14.0));
        editButton.setOnAction(e->{
            if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Customer")){
                EventDetailsPage edp = new EventDetailsPage();
                edp.setEvent(event);
                edp.start(primaryStage);
            }else{
                EditCampaignPage ecp = new EditCampaignPage();
                ecp.setEvent(event);
                ecp.setCam(cam);
                ecp.start(primaryStage);
            }
        });

        Label campaignDetailsLabel = new Label("Campaign Details");
        campaignDetailsLabel.setLayoutX(16.0);
        campaignDetailsLabel.setLayoutY(204.0);
        campaignDetailsLabel.setPrefSize(131.0, 22.0);
        campaignDetailsLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        campaignDetailsLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        campaignDetailsLabel.setFont(Font.font("System Bold", 15.0));

        ImageView imageView = new ImageView();
        imageView.setImage(back);
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(798.0);
        imageView.setLayoutX(11.0);
        imageView.setLayoutY(46.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);

        Label campaignDetailsLabel2 = new Label("Description");
        campaignDetailsLabel2.setLayoutX(16.0);
        campaignDetailsLabel2.setLayoutY(230.0);
        campaignDetailsLabel2.setPrefSize(131.0, 22.0);
        campaignDetailsLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        campaignDetailsLabel2.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        campaignDetailsLabel2.setFont(Font.font(14.0));

        Label campaignDetailsLabel3 = new Label(cam.getDescription());
        campaignDetailsLabel3.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        campaignDetailsLabel3.setLayoutX(16.0);
        campaignDetailsLabel3.setLayoutY(252.0);
        campaignDetailsLabel3.setMaxHeight(Double.POSITIVE_INFINITY);
        campaignDetailsLabel3.setMaxWidth(Double.POSITIVE_INFINITY);
        campaignDetailsLabel3.setPrefHeight(46.0);
        campaignDetailsLabel3.setPrefWidth(472.0);
        campaignDetailsLabel3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        campaignDetailsLabel3.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        campaignDetailsLabel3.setFont(Font.font("System Italic", 14.0));

        if (!SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Customer")){
            Label campaignAnalyticsLabel = new Label("Campaign Analytics");
            campaignAnalyticsLabel.setLayoutX(16.0);
            campaignAnalyticsLabel.setLayoutY(355.0);
            campaignAnalyticsLabel.setPrefHeight(22.0);
            campaignAnalyticsLabel.setPrefWidth(131.0);
            campaignAnalyticsLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            campaignAnalyticsLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            campaignAnalyticsLabel.setFont(Font.font(14.0));

            Pane analyticsPane1 = new Pane();
            analyticsPane1.setLayoutX(166.0);
            analyticsPane1.setLayoutY(382.0);
            analyticsPane1.setPrefHeight(100.0);
            analyticsPane1.setPrefWidth(140.0);
            analyticsPane1.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

            Label analyticsTitleLabel1 = new Label("Average Traffic");
            analyticsTitleLabel1.setLayoutY(10.0);
            analyticsTitleLabel1.setPrefSize(140.0, 20.0);
            analyticsTitleLabel1.setAlignment(javafx.geometry.Pos.CENTER);
            analyticsTitleLabel1.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            analyticsTitleLabel1.setFont(Font.font("System Bold", 15.0));

            Label analyticsCountLabel1 = new Label("50");
            analyticsCountLabel1.setLayoutY(48.0);
            analyticsCountLabel1.setPrefSize(140.0, 20.0);
            analyticsCountLabel1.setAlignment(javafx.geometry.Pos.CENTER);
            analyticsCountLabel1.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
            analyticsCountLabel1.setFont(Font.font("System Bold", 24.0));

            analyticsPane1.getChildren().addAll(analyticsTitleLabel1, analyticsCountLabel1);

            Pane analyticsPane2 = new Pane();
            analyticsPane2.setLayoutX(318.0);
            analyticsPane2.setLayoutY(382.0);
            analyticsPane2.setPrefHeight(100.0);
            analyticsPane2.setPrefWidth(140.0);
            analyticsPane2.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

            Label analyticsTitleLabel2 = new Label("Average Clicks");
            analyticsTitleLabel2.setLayoutY(10.0);
            analyticsTitleLabel2.setPrefSize(140.0, 20.0);
            analyticsTitleLabel2.setAlignment(javafx.geometry.Pos.CENTER);
            analyticsTitleLabel2.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            analyticsTitleLabel2.setFont(Font.font("System Bold", 15.0));

            Label analyticsCountLabel2 = new Label("30");
            analyticsCountLabel2.setLayoutY(46.0);
            analyticsCountLabel2.setPrefSize(140.0, 20.0);
            analyticsCountLabel2.setAlignment(javafx.geometry.Pos.CENTER);
            analyticsCountLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
            analyticsCountLabel2.setFont(Font.font("System Bold", 24.0));

            analyticsPane2.getChildren().addAll(analyticsTitleLabel2, analyticsCountLabel2);

            Pane errorPane = new Pane();
            errorPane.setLayoutX(16.0);
            errorPane.setLayoutY(382.0);
            errorPane.setPrefSize(140.0, 100.0);
            errorPane.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

            Label errorTitleLabel = new Label("Average Bookings");
            errorTitleLabel.setLayoutY(10.0);
            errorTitleLabel.setPrefSize(140.0, 20.0);
            errorTitleLabel.setAlignment(javafx.geometry.Pos.CENTER);
            errorTitleLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            errorTitleLabel.setFont(Font.font("System Bold", 15.0));

            Label errorCountLabel = new Label("20");
            errorCountLabel.setLayoutY(48.0);
            errorCountLabel.setPrefSize(140.0, 20.0);
            errorCountLabel.setAlignment(javafx.geometry.Pos.CENTER);
            errorCountLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
            errorCountLabel.setFont(Font.font("System Bold", 24.0));

            errorPane.getChildren().addAll(errorTitleLabel, errorCountLabel);

            anchorPane.getChildren().addAll(errorPane, analyticsPane1, analyticsPane2,campaignAnalyticsLabel);
        }



        Label campaignEndDateLabel = new Label("Campaign End Date");
        campaignEndDateLabel.setLayoutX(16.0);
        campaignEndDateLabel.setLayoutY(304.0);
        campaignEndDateLabel.setPrefHeight(22.0);
        campaignEndDateLabel.setPrefWidth(131.0);
        campaignEndDateLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        campaignEndDateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        campaignEndDateLabel.setFont(Font.font(14.0));

        Label campaignEndDateLabel2 = new Label(cam.getEndDate().toString());
        campaignEndDateLabel2.setLayoutX(156.0);
        campaignEndDateLabel2.setLayoutY(304.0);
        campaignEndDateLabel2.setPrefHeight(22.0);
        campaignEndDateLabel2.setPrefWidth(131.0);
        campaignEndDateLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        campaignEndDateLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        campaignEndDateLabel2.setFont(Font.font("System Italic", 14.0));

        Label couponCodeLabel = new Label("Coupon Code");
        couponCodeLabel.setLayoutX(16.0);
        couponCodeLabel.setLayoutY(331.0);
        couponCodeLabel.setPrefHeight(20.0);
        couponCodeLabel.setPrefWidth(90.0);
        couponCodeLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        couponCodeLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        couponCodeLabel.setFont(Font.font(14.0));

        Label eventNameLabel = new Label(cam.getCoupon().getCode());
        eventNameLabel.setLayoutX(156.0);
        eventNameLabel.setLayoutY(330.0);
        eventNameLabel.setPrefHeight(20.0);
        eventNameLabel.setPrefWidth(90.0);
        eventNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        eventNameLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        eventNameLabel.setFont(Font.font("System Italic", 14.0));

        Pane pane = new Pane();
        pane.setLayoutX(417.6);
        pane.setLayoutY(204.0);
        pane.setPrefSize(300.0, 276.0);
        pane.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");
        AnchorPane.setRightAnchor(pane, 12.0);

        Label eventDetailsLabel = new Label("Event Details");
        eventDetailsLabel.setLayoutY(10.0);
        eventDetailsLabel.setPrefSize(300.0, 20.0);
        eventDetailsLabel.setAlignment(javafx.geometry.Pos.CENTER);
        eventDetailsLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        eventDetailsLabel.setFont(Font.font("System Bold", 15.0));

        Label eventNameLabel1 = new Label("Event Name");
        eventNameLabel1.setLayoutX(10.0);
        eventNameLabel1.setLayoutY(45.0);
        eventNameLabel1.setPrefSize(90.0, 20.0);
        eventNameLabel1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        eventNameLabel1.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        eventNameLabel1.setFont(Font.font(14.0));

        Label eventNameLabel2 = new Label(event.getName());
        eventNameLabel2.setLayoutX(102.0);
        eventNameLabel2.setLayoutY(45.0);
        eventNameLabel2.setPrefSize(90.0, 20.0);
        eventNameLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        eventNameLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        eventNameLabel2.setFont(Font.font(14.0));

        Label locationLabel = new Label("Location");
        locationLabel.setLayoutX(11.0);
        locationLabel.setLayoutY(82.0);
        locationLabel.setPrefSize(90.0, 20.0);
        locationLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        locationLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        locationLabel.setFont(Font.font(14.0));

        Label locationLabel2 = new Label(event.getLocation());
        locationLabel2.setLayoutX(103.0);
        locationLabel2.setLayoutY(82.0);
        locationLabel2.setPrefSize(90.0, 20.0);
        locationLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        locationLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        locationLabel2.setFont(Font.font(14.0));

        Label dateLabel = new Label("Date");
        dateLabel.setLayoutX(12.0);
        dateLabel.setLayoutY(119.0);
        dateLabel.setPrefSize(90.0, 20.0);
        dateLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        dateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        dateLabel.setFont(Font.font(14.0));

        Label dateLabel2 = new Label(event.getDate().toString());
        dateLabel2.setLayoutX(104.0);
        dateLabel2.setLayoutY(119.0);
        dateLabel2.setPrefSize(90.0, 20.0);
        dateLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        dateLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        dateLabel2.setFont(Font.font(14.0));

        Label ticketPriceLabel = new Label("Ticket Price");
        ticketPriceLabel.setLayoutX(13.0);
        ticketPriceLabel.setLayoutY(157.0);
        ticketPriceLabel.setPrefSize(90.0, 20.0);
        ticketPriceLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ticketPriceLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        ticketPriceLabel.setFont(Font.font(14.0));

        Label ticketPriceLabel2 = new Label(Integer.toString(event.getPrice()));
        ticketPriceLabel2.setLayoutX(105.0);
        ticketPriceLabel2.setLayoutY(157.0);
        ticketPriceLabel2.setPrefSize(90.0, 20.0);
        ticketPriceLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ticketPriceLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        ticketPriceLabel2.setFont(Font.font(14.0));

        Button viewEventButton = new Button("View Event");
        viewEventButton.setLayoutX(13.0);
        viewEventButton.setLayoutY(226.0);
        viewEventButton.setPrefSize(272.0, 35.0);
        viewEventButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
        viewEventButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        viewEventButton.setFont(Font.font("System Bold", 12.0));
        viewEventButton.setOnMouseEntered(e->{
            viewEventButton.setStyle("-fx-background-color: #ed7d29; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px; -fx-background-radius: 10px;");
            viewEventButton.setTextFill(javafx.scene.paint.Color.web("#fff"));
        });

        viewEventButton.setOnMouseExited(e->{
            viewEventButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
            viewEventButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        });

        viewEventButton.setOnAction(e->{
            EventDetailsPage edp = new EventDetailsPage();
            edp.setEvent(event);
            edp.start(primaryStage);
        });

        Label couponCodeLabel1 = new Label("Coupon Code");
        couponCodeLabel1.setLayoutX(13.0);
        couponCodeLabel1.setLayoutY(188.0);
        couponCodeLabel1.setPrefSize(90.0, 20.0);
        couponCodeLabel1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        couponCodeLabel1.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        couponCodeLabel1.setFont(Font.font(14.0));

        Label couponCodeLabel2 = new Label(cam.getCoupon().getCode());
        couponCodeLabel2.setLayoutX(105.0);
        couponCodeLabel2.setLayoutY(188.0);
        couponCodeLabel2.setPrefSize(90.0, 20.0);
        couponCodeLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        couponCodeLabel2.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        couponCodeLabel2.setFont(Font.font(14.0));

        pane.getChildren().addAll(eventDetailsLabel, eventNameLabel1, eventNameLabel2, locationLabel, locationLabel2,
                dateLabel, dateLabel2, ticketPriceLabel, ticketPriceLabel2, viewEventButton, couponCodeLabel1, couponCodeLabel2);


        anchorPane.getChildren().addAll(pane, titleLabel, closeButton, editButton, campaignDetailsLabel, imageView, campaignDetailsLabel2, campaignDetailsLabel3, campaignEndDateLabel, campaignEndDateLabel2, couponCodeLabel, eventNameLabel);

        primaryStage.setCenter(anchorPane);
    }

}


