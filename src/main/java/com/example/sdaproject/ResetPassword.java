package com.example.sdaproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class ResetPassword extends Application {
    public static String username;

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000.0, 600.0);

        File file = new File("src/images/logo.png");
        Image image = new Image(file.toURI().toString());

        file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());


        ImageView imageView = new ImageView();
        imageView.setFitHeight(600.0);
        imageView.setFitWidth(1000.0);
        imageView.setLayoutX(227.0);
        imageView.setLayoutY(112.0);
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
        AnchorPane.setBottomAnchor(pane, 80.0);
        AnchorPane.setRightAnchor(pane, 300.0);
        AnchorPane.setTopAnchor(pane, 80.0);

        Label forgotPasswordLabel = new Label("Reset Password");
        forgotPasswordLabel.setLayoutX(89.0);
        forgotPasswordLabel.setLayoutY(25.0);
        forgotPasswordLabel.setTextFill(Paint.valueOf("#363e7c"));
        forgotPasswordLabel.setFont(Font.font("System Bold", 24.0));

        Label usernameLabel = new Label("Enter Password");
        usernameLabel.setLayoutX(37.0);
        usernameLabel.setLayoutY(79.0);
        usernameLabel.setTextFill(Paint.valueOf("#363e7c"));
        usernameLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));


        Label securityQuestionLabel = new Label("Confirm Password");
        securityQuestionLabel.setLayoutX(37.0);
        securityQuestionLabel.setLayoutY(147.0);
        securityQuestionLabel.setTextFill(Paint.valueOf("#363e7c"));
        securityQuestionLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 14.0));

        TextField passField = new TextField();
        passField.setLayoutX(37.0);
        passField.setLayoutY(102.0);
        passField.setPrefHeight(25.0);
        passField.setPrefWidth(284.0);
        passField.setPromptText("Enter New Password");

        TextField c_passField = new TextField();
        c_passField.setLayoutX(37.0);
        c_passField.setLayoutY(170.0);
        c_passField.setPrefHeight(25.0);
        c_passField.setPrefWidth(284.0);
        c_passField.setPromptText("Re-Enter Password");

        Label errorLabel = new Label("Error");
        errorLabel.setLayoutX(37.0);
        errorLabel.setLayoutY(310.0);
        errorLabel.setTextFill(Paint.valueOf("RED"));
        errorLabel.setVisible(false);

        Button recoverPasswordButton = new Button("Reset Password");
        recoverPasswordButton.setLayoutX(80.0);
        recoverPasswordButton.setLayoutY(345.0);
        recoverPasswordButton.setMnemonicParsing(false);
        recoverPasswordButton.setPrefHeight(35.0);
        recoverPasswordButton.setPrefWidth(208.0);
        recoverPasswordButton.setStyle("-fx-background-color: #343e7c;");
        recoverPasswordButton.setTextFill(javafx.scene.paint.Color.WHITE);
        recoverPasswordButton.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        Button cancelButton = new Button("Cancel");
        cancelButton.setLayoutX(13.0);
        cancelButton.setLayoutY(401.0);
        cancelButton.setMnemonicParsing(false);
        cancelButton.setPrefHeight(23.0);
        cancelButton.setPrefWidth(100.0);
        cancelButton.setStyle("-fx-background-color: #ed7d29;");
        cancelButton.setTextFill(javafx.scene.paint.Color.WHITE);
        cancelButton.setOnMouseClicked(e->{
            Login l = new Login();
            try {
                l.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        recoverPasswordButton.setOnMouseClicked(e->{
            errorLabel.setVisible(true);
            String response = AuthenticationController.getInstance().setPassword(username, passField.getText(), c_passField.getText());
            errorLabel.setText(response);
            if (response.equals("Updated")){
                errorLabel.setText("Password Updated Successfully");
                errorLabel.setTextFill(Color.GREEN);
                cancelButton.setPrefSize(208,35);
                cancelButton.setLayoutX(80);
                cancelButton.setLayoutY(345);
                cancelButton.setText("Login");
                cancelButton.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));
            }
        });


        pane.getChildren().addAll(forgotPasswordLabel, usernameLabel, securityQuestionLabel, passField, c_passField,
                errorLabel, recoverPasswordButton, cancelButton);

        ImageView logoImageView = new ImageView();
        logoImageView.setImage(image);
        logoImageView.setFitHeight(69.0);
        logoImageView.setFitWidth(100.0);
        logoImageView.setLayoutX(14.0);
        logoImageView.setLayoutY(14.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);

        root.getChildren().addAll(imageView, pane, logoImageView);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Reset Password");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
