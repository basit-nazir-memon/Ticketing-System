package com.example.sdaproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.File;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000.0, 600.0);

        File file = new File("src/images/logo.png");
        Image image = new Image(file.toURI().toString());

        file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        ImageView imageView = new ImageView();
        imageView.setFitWidth(1000.0);
        imageView.setFitHeight(600.0);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        imageView.setImage(back);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        AnchorPane.setBottomAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);

        Pane pane = new Pane();
        pane.setLayoutX(600.0);
        pane.setLayoutY(49.0);
        pane.setPrefHeight(485.0);
        pane.setPrefWidth(357.0);
        pane.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-width: 4px;");
        AnchorPane.setBottomAnchor(pane, 50.0);
        AnchorPane.setRightAnchor(pane, 42.39999999999998);
        AnchorPane.setTopAnchor(pane, 50.0);

        Label loginLabel = new Label("Login");
        loginLabel.setLayoutX(147.0);
        loginLabel.setLayoutY(67.0);
        loginLabel.setTextFill(Paint.valueOf("#363e7c"));
        loginLabel.setFont(Font.font("System Bold", 24.0));

        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(34.0);
        usernameLabel.setLayoutY(123.0);
        usernameLabel.setTextFill(Paint.valueOf("#363e7c"));
        usernameLabel.setFont(Font.font(14.0));

        Label passwordLabel = new Label("Password");
        passwordLabel.setLayoutX(36.0);
        passwordLabel.setLayoutY(188.0);
        passwordLabel.setTextFill(Paint.valueOf("#363e7c"));
        passwordLabel.setFont(Font.font(14.0));

        TextField usernameField = new TextField();
        usernameField.setLayoutX(34.0);
        usernameField.setLayoutY(145.0);
        usernameField.setPrefHeight(25.0);
        usernameField.setPrefWidth(284.0);
        usernameField.setPromptText("username");

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(34.0);
        passwordField.setLayoutY(211.0);
        passwordField.setPrefHeight(25.0);
        passwordField.setPrefWidth(284.0);
        passwordField.setPromptText("password");

        Hyperlink forgotPasswordLink = new Hyperlink("forgot password?");
        forgotPasswordLink.setLayoutX(216.0);
        forgotPasswordLink.setLayoutY(238.0);
        forgotPasswordLink.setPrefHeight(23.0);
        forgotPasswordLink.setPrefWidth(106.0);
        forgotPasswordLink.setTextFill(Paint.valueOf("#363e7c"));
        forgotPasswordLink.setOnMouseClicked(e->{
            ForgotPassword f = new ForgotPassword();
            try {
                f.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });



        Label errorLabel = new Label("Error");
        errorLabel.setLayoutX(36.0);
        errorLabel.setLayoutY(292.0);
        errorLabel.setTextFill(Paint.valueOf("RED"));
        errorLabel.setVisible(false);


        Button loginButton = new Button("Login");
        loginButton.setLayoutX(80.0);
        loginButton.setLayoutY(323.0);
        loginButton.setMnemonicParsing(false);
        loginButton.setPrefHeight(35.0);
        loginButton.setPrefWidth(208.0);
        loginButton.setStyle("-fx-background-color: #343e7c;");
        loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        loginButton.setFont(Font.font("System Bold", 14.0));
        loginButton.setOnMouseClicked(e->{
            errorLabel.setVisible(true);
            String response = AuthenticationController.getInstance().login(usernameField.getText(), passwordField.getText());
            errorLabel.setText(response);
            if (response.equals("Admin")){
                AdminPanel up = new AdminPanel();
                try {
                    up.start(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (response.equals("Customer")) {
                UserPanel up = new UserPanel();
                try {
                    up.start(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (response.equals("Support Team")) {
                SupportTeamPanel up = new SupportTeamPanel();
                try {
                    up.start(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (response.equals("Event Organizer")) {
                EventOrganizerPanel up = new EventOrganizerPanel();
                try {
                    up.start(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Button signUpButton = new Button("SignUp");
        signUpButton.setLayoutX(184.0);
        signUpButton.setLayoutY(443.0);
        signUpButton.setMnemonicParsing(false);
        signUpButton.setPrefHeight(30.0);
        signUpButton.setPrefWidth(150.0);
        signUpButton.setStyle("-fx-background-color: #ed7d29;");
        signUpButton.setTextFill(javafx.scene.paint.Color.WHITE);
        signUpButton.setOnMouseClicked(e->{
            SignUpPage sup = new SignUpPage();
            sup.start(primaryStage);
        });

        Label accountLabel = new Label("Don't have an account?");
        accountLabel.setLayoutX(210.0);
        accountLabel.setLayoutY(426.0);

        pane.getChildren().addAll(loginLabel, usernameLabel, passwordLabel, usernameField, passwordField,
                forgotPasswordLink, errorLabel, loginButton, signUpButton, accountLabel);

        ImageView logoImageView = new ImageView();
        logoImageView.setFitHeight(69.0);
        logoImageView.setFitWidth(100.0);
        logoImageView.setLayoutX(14.0);
        logoImageView.setLayoutY(14.0);
        logoImageView.setImage(image);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);

        root.getChildren().addAll(imageView, pane, logoImageView);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
