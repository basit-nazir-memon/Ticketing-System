package com.example.sdaproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.util.ArrayList;

public class SettingsPage {

    ArrayList<RequestSupport> supports;

    public void start(BorderPane primaryStage) {
        if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Admin") ){
            supports = SingletonTicketingSystemController.getInstance().getSupport();
        }else if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Support Team")){
            supports = SingletonTicketingSystemController.getInstance().getSupportRequests();
        }else{
            supports = SingletonTicketingSystemController.getInstance().getCustomerSupport();
        }

        File file = new File("src/images/frame.png");
        Image image = new Image(file.toURI().toString());

        AnchorPane root = new AnchorPane();
        root.setMaxHeight(Double.NEGATIVE_INFINITY);
        root.setMaxWidth(Double.NEGATIVE_INFINITY);
        root.setMinHeight(Double.NEGATIVE_INFINITY);
        root.setMinWidth(Double.NEGATIVE_INFINITY);
        root.setPrefHeight(550.0);
        root.setPrefWidth(820.0);
        root.setStyle("-fx-background-color: white;");

        Label supportLabel = new Label("Support");
        supportLabel.setLayoutX(14.0);
        supportLabel.setLayoutY(14.0);
        supportLabel.setPrefHeight(35.0);
        supportLabel.setPrefWidth(159.0);
        supportLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        supportLabel.setFont(Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC,24.0));

        Label previousSupportLabel = new Label("Previous Support / Messages");
        previousSupportLabel.setLayoutX(15.0);
        previousSupportLabel.setLayoutY(65.0);
        previousSupportLabel.setPrefHeight(22.0);
        previousSupportLabel.setPrefWidth(243.0);
        previousSupportLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        previousSupportLabel.setFont(Font.font("System Bold",FontWeight.BOLD, 15.0));

        if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Customer") || (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Event Organizer"))){
            Button requestSupportButton = new Button("Request Support");
            requestSupportButton.setLayoutX(646.0);
            requestSupportButton.setLayoutY(14.0);
            requestSupportButton.setMnemonicParsing(false);
            requestSupportButton.setPrefHeight(31.0);
            requestSupportButton.setPrefWidth(159.0);
            requestSupportButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
            requestSupportButton.setTextFill(javafx.scene.paint.Color.WHITE);
            requestSupportButton.setFont(Font.font("System Bold",FontWeight.BOLD, 14.0));
            requestSupportButton.setOnAction(e -> {
                RequestSupportPage rsp = new RequestSupportPage();
                rsp.start(primaryStage);
            });
            root.getChildren().add(requestSupportButton);
        }

        int i = 0;
        for (RequestSupport rs: supports) {
            Pane pane = new Pane();
            pane.setLayoutX(14.0);
            pane.setLayoutY(94.0 + i*65);
            pane.setPrefHeight(60.0);
            pane.setPrefWidth(792.0);
            pane.setStyle("-fx-background-color: WHite; -fx-background-radius: 10px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");

            Label nameLabel = new Label(rs.getQuestionTopic());
            nameLabel.setLayoutX(84.0);
            nameLabel.setLayoutY(13.0);
            nameLabel.setPrefHeight(20.0);
            nameLabel.setPrefWidth(98.0);
            nameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            nameLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14.0));

            if (SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Customer") || SingletonTicketingSystemController.getInstance().getLoggedInUser().getRole().equals("Event Organizer")){
                nameLabel.setText(rs.getSupportPersonId().getFirstName() + " " + rs.getSupportPersonId().getLastName());
            }else{
                nameLabel.setText(rs.getCustomerId().getFirstName() + " " + rs.getCustomerId().getLastName());
            }

            ImageView imageView = new ImageView();
            imageView.setFitHeight(50.0);
            imageView.setFitWidth(52.0);
            imageView.setLayoutX(14.0);
            imageView.setLayoutY(5.0);
            imageView.setImage(image);
            imageView.setPickOnBounds(false);
            imageView.setPreserveRatio(true);

            Label inquiryLabel = new Label(rs.getQuestion());
            inquiryLabel.setLayoutX(85.0);
            inquiryLabel.setLayoutY(33.0);
            inquiryLabel.setPrefHeight(20.0);
            inquiryLabel.setPrefWidth(300.0);
            inquiryLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            inquiryLabel.setFont(Font.font("System Italic", FontPosture.ITALIC, 12.0));

            Label dateLabel = new Label(rs.getDateTime().toString());
            dateLabel.setLayoutX(714.0);
            dateLabel.setLayoutY(20.0);
            dateLabel.setPrefHeight(20.0);
            dateLabel.setPrefWidth(69.0);
            dateLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

            pane.getChildren().addAll(nameLabel, imageView, inquiryLabel, dateLabel);
            pane.setOnMouseClicked(e -> {
                MessagePage mp = new MessagePage();
                mp.setRs(rs);
                mp.start(primaryStage);
            });
            root.getChildren().add(pane);
            i++;
        }

        root.getChildren().addAll(supportLabel, previousSupportLabel);


        primaryStage.setCenter(root);
    }
}