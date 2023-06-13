package com.example.sdaproject;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RequestSupportPage {

    public void start(BorderPane primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setMaxHeight(Double.NEGATIVE_INFINITY);
        root.setMaxWidth(Double.NEGATIVE_INFINITY);
        root.setMinHeight(Double.NEGATIVE_INFINITY);
        root.setMinWidth(Double.NEGATIVE_INFINITY);
        root.setPrefHeight(550.0);
        root.setPrefWidth(820.0);
        root.setStyle("-fx-background-color: white;");

        Label titleLabel = new Label("Request Support");
        titleLabel.setLayoutX(14.0);
        titleLabel.setLayoutY(45.0);
        titleLabel.setPrefHeight(35.0);
        titleLabel.setPrefWidth(211.0);
        titleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        titleLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        titleLabel.setFont(Font.font("System Bold", FontWeight.BOLD,24.0));

        Pane pane = new Pane();
        pane.setLayoutX(166.0);
        pane.setLayoutY(97.0);
        pane.setPrefHeight(355.0);
        pane.setPrefWidth(487.0);
        pane.setStyle("-fx-background-color: WHite; -fx-background-radius: 10px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");

        Label topicLabel = new Label("Question Topic");
        topicLabel.setLayoutX(14.0);
        topicLabel.setLayoutY(8.0);
        topicLabel.setPrefHeight(35.0);
        topicLabel.setPrefWidth(125.0);
        topicLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        topicLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        topicLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        ComboBox<String> topicComboBox = new ComboBox<>();
        topicComboBox.setLayoutX(14.0);
        topicComboBox.setLayoutY(41.0);
        topicComboBox.setPrefHeight(25.0);
        topicComboBox.setPrefWidth(457.0);
        topicComboBox.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        topicComboBox.getItems().addAll("Event", "Campaign", "Coupons", "Payment", "Other");

        Label questionLabel = new Label("Question");
        questionLabel.setLayoutX(14.0);
        questionLabel.setLayoutY(75.0);
        questionLabel.setPrefHeight(35.0);
        questionLabel.setPrefWidth(152.0);
        questionLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        questionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        questionLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

        TextArea questionTextArea = new TextArea();
        questionTextArea.setLayoutX(14.0);
        questionTextArea.setLayoutY(106.0);
        questionTextArea.setPrefHeight(178.0);
        questionTextArea.setPrefWidth(457.0);
        questionTextArea.setPromptText("Write your Question / Issue here");
        questionTextArea.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        Button requestButton = new Button("Request Support");
        requestButton.setLayoutX(321.0);
        requestButton.setLayoutY(310.0);
        requestButton.setMnemonicParsing(false);
        requestButton.setPrefHeight(30.0);
        requestButton.setPrefWidth(152.0);
        requestButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        requestButton.setTextFill(javafx.scene.paint.Color.WHITE);
        requestButton.setFont(Font.font("System Bold", 13.0));

        Label errorLabel = new Label("Error");
        errorLabel.setLayoutX(14.0);
        errorLabel.setLayoutY(281.0);
        errorLabel.setPrefHeight(35.0);
        errorLabel.setPrefWidth(152.0);
        errorLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        errorLabel.setTextFill(javafx.scene.paint.Color.RED);
        errorLabel.setFont(Font.font("System Bold", FontWeight.BOLD,13.0));
        errorLabel.setVisible(false);
        pane.getChildren().addAll(topicLabel, topicComboBox, questionLabel, questionTextArea, requestButton, errorLabel);

        Button backButton = new Button("Back");
        backButton.setLayoutX(5.0);
        backButton.setLayoutY(7.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(30.0);
        backButton.setPrefWidth(69.0);
        backButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        backButton.setTextFill(javafx.scene.paint.Color.WHITE);
        backButton.setFont(Font.font(13.0));
        backButton.setOnAction(e->{
            SettingsPage ap = new SettingsPage();
            ap.start(primaryStage);
        });

        requestButton.setOnAction(e->{
            String response = SingletonTicketingSystemController.getInstance().requestSupport(questionTextArea.getText(), topicComboBox.getValue(), SessionStorage.getInstance().getUser());
            errorLabel.setText(response);
            if (response.equals("Success")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Request Submitted");
                alert.setContentText("The Support Request has been submitted Successfully. The Concerned Team will contact you shortly...");
                alert.showAndWait();
                SettingsPage sp = new SettingsPage();
                sp.start(primaryStage);
            }else{
                errorLabel.setVisible(true);
            }
        });

        root.getChildren().addAll(titleLabel, pane, backButton);

        primaryStage.setCenter(root);
    }

}
