package com.example.sdaproject;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;

public class MessagePage{
    RequestSupport rs;

    public void setRs(RequestSupport rs) {
        this.rs = rs;
    }

    AnchorPane root = new AnchorPane();
    BorderPane primaryStage;

    private void loadScreen(){
        File file = new File("src/images/frame.png");
        Image image = new Image(file.toURI().toString());


        root.setMaxHeight(Double.NEGATIVE_INFINITY);
        root.setMaxWidth(Double.NEGATIVE_INFINITY);
        root.setMinHeight(Double.NEGATIVE_INFINITY);
        root.setMinWidth(Double.NEGATIVE_INFINITY);
        root.setPrefHeight(550.0);
        root.setPrefWidth(820.0);
        root.setStyle("-fx-background-color: white;");

        Label nameLabel = new Label();
        nameLabel.setLayoutX(91.0);
        nameLabel.setLayoutY(5.0);
        nameLabel.setPrefHeight(35.0);
        nameLabel.setPrefWidth(159.0);
        nameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        nameLabel.setFont(Font.font("System Bold", FontWeight.BOLD,18.0));
        if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Customer") || SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Event Organizer")){
            nameLabel.setText(rs.getSupportPersonId().getFirstName() + " " + rs.getSupportPersonId().getLastName());
        }else{
            nameLabel.setText(rs.getCustomerId().getFirstName() + " " + rs.getCustomerId().getLastName());
        }

        int i = 0;
        int id = SingletonTicketingSystemController.getInstance().getLoggedInUser().getId();
        for (Message m: rs.messages) {
            if (m.getUserId().getId() != id) {
                Pane pane = new Pane();
                pane.setLayoutX(14.0);
                pane.setLayoutY(57.0 + i*65);
                pane.setPrefHeight(60.0);
                pane.setPrefWidth(792.0);
                pane.setStyle("-fx-background-color: WHite; -fx-background-radius: 10px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");

                ImageView imageView = new ImageView();
                imageView.setFitHeight(50.0);
                imageView.setFitWidth(52.0);
                imageView.setLayoutX(9.0);
                imageView.setLayoutY(5.0);
                imageView.setImage(image);
                imageView.setPickOnBounds(true);
                imageView.setPreserveRatio(false);

                Label messageLabel1 = new Label(m.getMessage());
                messageLabel1.setLayoutX(70.0);
                messageLabel1.setLayoutY(8.0);
                messageLabel1.setPrefHeight(43.0);
                messageLabel1.setPrefWidth(626.0);
                messageLabel1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
                messageLabel1.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
                messageLabel1.setFont(Font.font(13.0));

                Label dateLabel1 = new Label(m.getDateTime().toString());
                dateLabel1.setLayoutX(721.0);
                dateLabel1.setLayoutY(36.0);
                dateLabel1.setPrefHeight(20.0);
                dateLabel1.setPrefWidth(69.0);
                dateLabel1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
                dateLabel1.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

                pane.getChildren().addAll(imageView, messageLabel1, dateLabel1);
                root.getChildren().add(pane);
            }else {
                Pane pane1 = new Pane();
                pane1.setLayoutX(14.0);
                pane1.setLayoutY(57 + i*65);
                pane1.setPrefHeight(60.0);
                pane1.setPrefWidth(792.0);
                pane1.setStyle("-fx-background-color: WHite; -fx-background-radius: 10px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");

                ImageView imageView2 = new ImageView();
                imageView2.setFitHeight(50.0);
                imageView2.setFitWidth(52.0);
                imageView2.setLayoutX(729.0);
                imageView2.setImage(image);
                imageView2.setLayoutY(5.0);
                imageView2.setPickOnBounds(true);
                imageView2.setPreserveRatio(false);

                Label messageLabel2 = new Label(m.getMessage());
                messageLabel2.setLayoutX(96.0);
                messageLabel2.setLayoutY(9.0);
                messageLabel2.setMaxHeight(Double.NEGATIVE_INFINITY);
                messageLabel2.setMaxWidth(Double.NEGATIVE_INFINITY);
                messageLabel2.setMinHeight(Double.NEGATIVE_INFINITY);
                messageLabel2.setMinWidth(Double.NEGATIVE_INFINITY);
                messageLabel2.setPrefHeight(43.0);
                messageLabel2.setPrefWidth(626.0);
                messageLabel2.setAlignment(Pos.CENTER_RIGHT);
                messageLabel2.setTextFill(javafx.scene.paint.Color.valueOf("#ed7d29"));
                messageLabel2.setFont(Font.font(13.0));

                Label dateLabel2 = new Label(m.getDateTime().toString());
                dateLabel2.setLayoutX(11.0);
                dateLabel2.setLayoutY(36.0);
                dateLabel2.setPrefHeight(20.0);
                dateLabel2.setPrefWidth(69.0);
                dateLabel2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
                dateLabel2.setTextFill(javafx.scene.paint.Color.valueOf("#ed7d29"));

                pane1.getChildren().addAll(imageView2, messageLabel2, dateLabel2);

                root.getChildren().add(pane1);
            }
            i++;
        }
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

        root.getChildren().addAll(nameLabel, backButton);

        Button sendButton = new Button("Send");
        sendButton.setLayoutX(720.0);
        sendButton.setLayoutY(512.0);
        sendButton.setMnemonicParsing(false);
        sendButton.setPrefHeight(20.0);
        sendButton.setPrefWidth(90.0);
        sendButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        sendButton.setTextFill(javafx.scene.paint.Color.WHITE);
        sendButton.setFont(Font.font("System Bold", FontWeight.BOLD,13.0));

        TextField messageField = new TextField();
        messageField.setLayoutX(58.0);
        messageField.setLayoutY(512.0);
        messageField.setPrefHeight(30.0);
        messageField.setPrefWidth(654.0);
        messageField.setPromptText("Enter Message");
        messageField.setStyle("-fx-background-color: WHITE; -fx-border-radius: 5px; -fx-border-color: #343e7c;");

        ImageView imageView1 = new ImageView();
        imageView1.setFitHeight(35.0);
        imageView1.setFitWidth(35.0);
        imageView1.setLayoutX(15.0);
        imageView1.setImage(image);
        imageView1.setLayoutY(510.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(false);

        sendButton.setOnAction(e->{
            String response = SingletonTicketingSystemController.getInstance().sendMessage(messageField.getText(), rs);
            if (response.equals("Success")){
                messageField.clear();
//                root.getChildren().clear();
                loadScreen();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Message Not Sent");
                alert.setContentText(response);
                alert.showAndWait();
            }
        });

        root.getChildren().addAll(sendButton, messageField, imageView1);
    }


    public void start(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
        loadScreen();
        this.primaryStage.setCenter(root);
    }

}
