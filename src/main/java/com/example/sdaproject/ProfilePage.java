package com.example.sdaproject;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ProfilePage {

    public void start(BorderPane primaryStage) {

        User user = SingletonTicketingSystemController.getInstance().getLoggedInUser();

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setMaxHeight(Double.NEGATIVE_INFINITY);
        anchorPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        anchorPane.setMinHeight(Double.NEGATIVE_INFINITY);
        anchorPane.setMinWidth(Double.NEGATIVE_INFINITY);
        anchorPane.setPrefHeight(550.0);
        anchorPane.setPrefWidth(820.0);
        anchorPane.setStyle("-fx-background-color: white;");

        Label profileLabel = new Label("Profile");
        profileLabel.setLayoutX(22.0);
        profileLabel.setLayoutY(14.0);
        profileLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        profileLabel.setFont(Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC, 28.0));

        Pane imagePane = new Pane();
        imagePane.setLayoutX(603.0);
        imagePane.setLayoutY(77.0);
        imagePane.setPrefHeight(200.0);
        imagePane.setPrefWidth(170.0);
        imagePane.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");
        AnchorPane.setLeftAnchor(imagePane, 603.0);
        AnchorPane.setRightAnchor(imagePane, 48.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(190.0);
        imageView.setFitWidth(160.0);
        imageView.setLayoutX(5.0);
        imageView.setLayoutY(5.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        Label firstNameLabel = new Label("First Name");
        firstNameLabel.setLayoutX(61.0);
        firstNameLabel.setLayoutY(82.0);
        firstNameLabel.setPrefHeight(20.0);
        firstNameLabel.setPrefWidth(98.0);
        firstNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        firstNameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        firstNameLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label lastNameLabel = new Label("Last Name");
        lastNameLabel.setLayoutX(61.0);
        lastNameLabel.setLayoutY(133.0);
        lastNameLabel.setPrefHeight(20.0);
        lastNameLabel.setPrefWidth(98.0);
        lastNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lastNameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        lastNameLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(61.0);
        usernameLabel.setLayoutY(185.0);
        usernameLabel.setPrefHeight(20.0);
        usernameLabel.setPrefWidth(98.0);
        usernameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        usernameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        usernameLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label dobLabel = new Label("DOB");
        dobLabel.setLayoutX(61.0);
        dobLabel.setLayoutY(236.0);
        dobLabel.setPrefHeight(20.0);
        dobLabel.setPrefWidth(98.0);
        dobLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        dobLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        dobLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label genderLabel = new Label("Gender");
        genderLabel.setLayoutX(61.0);
        genderLabel.setLayoutY(329.0);
        genderLabel.setPrefHeight(20.0);
        genderLabel.setPrefWidth(98.0);
        genderLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        genderLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        genderLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label emailLabel = new Label("Email");
        emailLabel.setLayoutX(61.0);
        emailLabel.setLayoutY(285.0);
        emailLabel.setPrefHeight(20.0);
        emailLabel.setPrefWidth(98.0);
        emailLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        emailLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label roleLabel = new Label("Role");
        roleLabel.setLayoutX(61.0);
        roleLabel.setLayoutY(375.0);
        roleLabel.setPrefHeight(20.0);
        roleLabel.setPrefWidth(98.0);
        roleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        roleLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        roleLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Label firstNameValueLabel = new Label(user.getFirstName());
        firstNameValueLabel.setLayoutX(188.0);
        firstNameValueLabel.setLayoutY(82.0);
        firstNameValueLabel.setPrefHeight(20.0);
        firstNameValueLabel.setPrefWidth(98.0);
        firstNameValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        firstNameValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        firstNameValueLabel.setFont(Font.font(14.0));

        Label lastNameValueLabel = new Label(user.getLastName());
        lastNameValueLabel.setLayoutX(188.0);
        lastNameValueLabel.setLayoutY(133.0);
        lastNameValueLabel.setPrefHeight(20.0);
        lastNameValueLabel.setPrefWidth(98.0);
        lastNameValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lastNameValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        lastNameValueLabel.setFont(Font.font(14.0));

        Label usernameValueLabel = new Label(user.getUsername());
        usernameValueLabel.setLayoutX(188.0);
        usernameValueLabel.setLayoutY(185.0);
        usernameValueLabel.setPrefHeight(20.0);
        usernameValueLabel.setPrefWidth(98.0);
        usernameValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        usernameValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        usernameValueLabel.setFont(Font.font(14.0));

        Label dobValueLabel = new Label(user.getDob().toString());
        dobValueLabel.setLayoutX(188.0);
        dobValueLabel.setLayoutY(236.0);
        dobValueLabel.setPrefHeight(20.0);
        dobValueLabel.setPrefWidth(98.0);
        dobValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        dobValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        dobValueLabel.setFont(Font.font(14.0));

        Label genderValueLabel = new Label(user.getGender());
        genderValueLabel.setLayoutX(188.0);
        genderValueLabel.setLayoutY(329.0);
        genderValueLabel.setPrefHeight(20.0);
        genderValueLabel.setPrefWidth(98.0);
        genderValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        genderValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        genderValueLabel.setFont(Font.font(14.0));

        Label emailValueLabel = new Label(user.getEmail());
        emailValueLabel.setLayoutX(188.0);
        emailValueLabel.setLayoutY(285.0);
        emailValueLabel.setPrefHeight(20.0);
        emailValueLabel.setPrefWidth(98.0);
        emailValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        emailValueLabel.setFont(Font.font(14.0));

        Label roleValueLabel = new Label(user.getRole());
        roleValueLabel.setLayoutX(188.0);
        roleValueLabel.setLayoutY(375.0);
        roleValueLabel.setPrefHeight(20.0);
        roleValueLabel.setPrefWidth(98.0);
        roleValueLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        roleValueLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        roleValueLabel.setFont(Font.font(14.0));

        anchorPane.getChildren().addAll(
                profileLabel,
                imagePane,
                firstNameLabel,
                lastNameLabel,
                usernameLabel,
                dobLabel,
                genderLabel,
                emailLabel,
                roleLabel,
                firstNameValueLabel,
                lastNameValueLabel,
                usernameValueLabel,
                dobValueLabel,
                genderValueLabel,
                emailValueLabel,
                roleValueLabel
        );

        primaryStage.setCenter(anchorPane);
    }
}