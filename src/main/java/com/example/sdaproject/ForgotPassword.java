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

public class ForgotPassword extends Application {

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

        Label forgotPasswordLabel = new Label("Forgot Password");
        forgotPasswordLabel.setLayoutX(89.0);
        forgotPasswordLabel.setLayoutY(25.0);
        forgotPasswordLabel.setTextFill(Paint.valueOf("#363e7c"));
        forgotPasswordLabel.setFont(Font.font("System Bold", 24.0));

        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(37.0);
        usernameLabel.setLayoutY(69.0);
        usernameLabel.setTextFill(Paint.valueOf("#363e7c"));
        usernameLabel.setFont(Font.font("System Bold", 14.0));

        Label securityQuestionLabel = new Label("Security Question");
        securityQuestionLabel.setLayoutX(37.0);
        securityQuestionLabel.setLayoutY(137.0);
        securityQuestionLabel.setTextFill(Paint.valueOf("#363e7c"));
        securityQuestionLabel.setFont(Font.font("System Bold", 14.0));

        TextField usernameField = new TextField();
        usernameField.setLayoutX(37.0);
        usernameField.setLayoutY(92.0);
        usernameField.setPrefHeight(25.0);
        usernameField.setPrefWidth(284.0);
        usernameField.setPromptText("username");


        Label errorLabel = new Label("Error");
        errorLabel.setLayoutX(37.0);
        errorLabel.setLayoutY(310.0);
        errorLabel.setTextFill(Paint.valueOf("RED"));
        errorLabel.setVisible(false);


        Label answerLabel = new Label("Enter Username First to get Question");
        answerLabel.setLayoutX(37.0);
        answerLabel.setLayoutY(157.0);
        answerLabel.setMaxWidth(Double.POSITIVE_INFINITY);
        answerLabel.setPrefHeight(48.0);
        answerLabel.setPrefWidth(284.0);
        answerLabel.setTextFill(Paint.valueOf("#363e7c"));
        answerLabel.setFont(Font.font(14.0));

        TextArea answerTextArea = new TextArea();
        answerTextArea.setLayoutX(37.0);
        answerTextArea.setLayoutY(212.0);
        answerTextArea.setPrefHeight(78.0);
        answerTextArea.setPrefWidth(284.0);
        answerTextArea.setPromptText("answer the question");
        answerTextArea.setOnMouseClicked(e->{
            answerLabel.setText(AuthenticationController.getInstance().getSecurityQuestion(usernameField.getText()));
        });

        Button recoverPasswordButton = new Button("Recover Password");
        recoverPasswordButton.setLayoutX(80.0);
        recoverPasswordButton.setLayoutY(345.0);
        recoverPasswordButton.setMnemonicParsing(false);
        recoverPasswordButton.setPrefHeight(35.0);
        recoverPasswordButton.setPrefWidth(208.0);
        recoverPasswordButton.setStyle("-fx-background-color: #343e7c;");
        recoverPasswordButton.setTextFill(javafx.scene.paint.Color.WHITE);
        recoverPasswordButton.setFont(Font.font("System Bold", 14.0));
        recoverPasswordButton.setOnMouseClicked(e->{
            errorLabel.setVisible(true);
            String response = AuthenticationController.getInstance().verifySecurityQuestion(usernameField.getText(), answerTextArea.getText());
            errorLabel.setText(response);
            if (response.equals("Verified")){
                ResetPassword rp = new ResetPassword();
                ResetPassword.username = usernameField.getText();
                try {
                    rp.start(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

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

        pane.getChildren().addAll(forgotPasswordLabel, usernameLabel, securityQuestionLabel, usernameField,
                errorLabel, recoverPasswordButton, cancelButton, answerLabel, answerTextArea);

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
        primaryStage.setTitle("Forgot Password");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
