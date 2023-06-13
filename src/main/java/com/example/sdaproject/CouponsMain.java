package com.example.sdaproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class CouponsMain {
    ArrayList<Coupon> coupons;
    HashMap<Coupon, Event> map;
    public void start(BorderPane primaryStage) {
        coupons = SingletonTicketingSystemController.getInstance().getCoupons();
        map = SingletonTicketingSystemController.getInstance().getCouponMap();

        File file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(820.0, 550.0);
        anchorPane.setStyle("-fx-background-color: white;");

        Label couponsLabel = new Label("Coupons");
        couponsLabel.setLayoutX(11.0);
        couponsLabel.setLayoutY(6.0);
        couponsLabel.setTextFill(Color.web("#363e7c"));
        couponsLabel.setFont(Font.font("System Bold Italic", 28.0));

        Button createCouponButton = new Button("Create Coupon");
        createCouponButton.setLayoutX(14.0);
        createCouponButton.setLayoutY(182.0);
        createCouponButton.setPrefSize(390.0, 46.0);
        createCouponButton.setStyle("-fx-background-color: #ed7d29; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        createCouponButton.setTextFill(Color.WHITE);
        createCouponButton.setFont(Font.font("System Bold", 14.0));
        createCouponButton.setOnAction(e -> {
            CreateCouponPage cpp = new CreateCouponPage();
            cpp.start(primaryStage);
        });

        Button viewAllButton = new Button("View All");
        viewAllButton.setLayoutX(733.0);
        viewAllButton.setLayoutY(243.0);
        viewAllButton.setPrefSize(72.0, 21.0);
        viewAllButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
        viewAllButton.setTextFill(Color.web("#ed7d29"));
        viewAllButton.setFont(Font.font("System Bold", 12.0));
        viewAllButton.setOnAction(e -> {
            CouponsPage cp = new CouponsPage();
            cp.start(primaryStage);
        });

        Pane pane1 = new Pane();
        pane1.setLayoutX(17.0);
        pane1.setLayoutY(57.0);
        pane1.setPrefSize(250.0, 113.0);
        pane1.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

        Label errorLabel1 = new Label("Error - Error");
        errorLabel1.setLayoutY(10.0);
        errorLabel1.setPrefSize(250.0, 20.0);
        errorLabel1.setAlignment(javafx.geometry.Pos.CENTER);
        errorLabel1.setTextFill(Color.web("#343e7c"));
        errorLabel1.setFont(Font.font("System Bold", 15.0));

        Label countLabel1 = new Label("10");
        countLabel1.setLayoutY(49.0);
        countLabel1.setPrefSize(250.0, 20.0);
        countLabel1.setAlignment(javafx.geometry.Pos.CENTER);
        countLabel1.setTextFill(Color.web("#ed7d29"));
        countLabel1.setFont(Font.font("System Bold", 24.0));

        pane1.getChildren().addAll(errorLabel1, countLabel1);

        Pane pane2 = new Pane();
        pane2.setLayoutX(285.0);
        pane2.setLayoutY(57.0);
        pane2.setPrefSize(250.0, 113.0);
        pane2.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

        Label errorLabel2 = new Label("Error - Error");
        errorLabel2.setLayoutY(10.0);
        errorLabel2.setPrefSize(250.0, 20.0);
        errorLabel2.setAlignment(javafx.geometry.Pos.CENTER);
        errorLabel2.setTextFill(Color.web("#343e7c"));
        errorLabel2.setFont(Font.font("System Bold", 15.0));

        Label countLabel2 = new Label("10");
        countLabel2.setLayoutY(49.0);
        countLabel2.setPrefSize(250.0, 20.0);
        countLabel2.setAlignment(javafx.geometry.Pos.CENTER);
        countLabel2.setTextFill(Color.web("#ed7d29"));
        countLabel2.setFont(Font.font("System Bold", 24.0));

        pane2.getChildren().addAll(errorLabel2, countLabel2);

        Pane pane3 = new Pane();
        pane3.setLayoutX(555.0);
        pane3.setLayoutY(57.0);
        pane3.setPrefSize(250.0, 113.0);
        pane3.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

        Label errorLabel3 = new Label("Error - Error");
        errorLabel3.setLayoutY(10.0);
        errorLabel3.setPrefSize(250.0, 20.0);
        errorLabel3.setAlignment(javafx.geometry.Pos.CENTER);
        errorLabel3.setTextFill(Color.web("#343e7c"));
        errorLabel3.setFont(Font.font("System Bold", 15.0));

        Label countLabel3 = new Label("10");
        countLabel3.setLayoutY(49.0);
        countLabel3.setPrefSize(250.0, 20.0);
        countLabel3.setAlignment(javafx.geometry.Pos.CENTER);
        countLabel3.setTextFill(Color.web("#ed7d29"));
        countLabel3.setFont(Font.font("System Bold", 24.0));

        pane3.getChildren().addAll(errorLabel3, countLabel3);

        Button cancelEditCouponButton = new Button("Cancel / Edit Coupon");
        cancelEditCouponButton.setLayoutX(415.0);
        cancelEditCouponButton.setLayoutY(182.0);
        cancelEditCouponButton.setPrefSize(390.0, 46.0);
        cancelEditCouponButton.setStyle("-fx-background-color: #343e7c; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        cancelEditCouponButton.setTextFill(Color.WHITE);
        cancelEditCouponButton.setFont(Font.font("System Bold", 14.0));
        cancelEditCouponButton.setOnAction(e -> {
            CouponsPage cp = new CouponsPage();
            cp.start(primaryStage);
        });

        Label couponsAvailableLabel = new Label("Coupons Available");
        couponsAvailableLabel.setLayoutX(17.0);
        couponsAvailableLabel.setLayoutY(246.0);
        couponsAvailableLabel.setPrefSize(250.0, 20.0);
        couponsAvailableLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        couponsAvailableLabel.setTextFill(Color.web("#343e7c"));
        couponsAvailableLabel.setFont(Font.font("System Bold", 15.0));

        int i = 0;
        for (Coupon c : coupons) {
            if (i >= 4) {
                break;
            }
            Pane pane4 = new Pane();
            pane4.setLayoutX(17.0);
            pane4.setLayoutY(279.0);
            pane4.setPrefSize(786.0, 50.0);
            pane4.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");

            ImageView imageView = new ImageView();
            imageView.setLayoutX(9.0);
            imageView.setLayoutY(3.0);
            imageView.setFitWidth(45.0);
            imageView.setFitHeight(45.0);
            imageView.setImage(back);
            imageView.setPreserveRatio(false);
            // Add image source for the ImageView here

            Label eventNameLabel = new Label(map.get(c).getName() + " - " + c.getCode());
            eventNameLabel.setLayoutX(65.0);
            eventNameLabel.setLayoutY(16.0);
            eventNameLabel.setPrefSize(250.0, 20.0);
            eventNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            eventNameLabel.setTextFill(Color.web("#343e7c"));
            eventNameLabel.setFont(Font.font("System Bold", 14.0));

            Button viewButton = new Button("Edit");
            viewButton.setLayoutX(687.0);
            viewButton.setLayoutY(12.0);
            viewButton.setPrefSize(90.0, 27.0);
            viewButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
            viewButton.setTextFill(Color.web("#ed7d29"));
            viewButton.setOnAction(e -> {
                EditCouponPage ecp = new EditCouponPage();
                ecp.setCoupon(c);
                ecp.setEvent(map.get(c));
                ecp.start(primaryStage);
            });

            pane4.getChildren().addAll(imageView, eventNameLabel, viewButton);
            anchorPane.getChildren().add(pane4);
            i++;
        }
        anchorPane.getChildren().addAll(
                couponsLabel,
                createCouponButton,
                viewAllButton,
                pane1,
                pane2,
                pane3,
                cancelEditCouponButton,
                couponsAvailableLabel
        );
        primaryStage.setCenter(anchorPane);
    }
}
