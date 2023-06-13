package com.example.sdaproject;


import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.io.File;
import java.sql.Date;

public class CreateEventPage {

    public void start(BorderPane primaryStage) {

        File file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(820.0);
        root.setPrefHeight(550.0);
        root.setStyle("-fx-background-color: white;");

        ImageView imageView1 = new ImageView();
        imageView1.setFitWidth(820.0);
        imageView1.setFitHeight(550.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(false);
        root.getChildren().add(imageView1);

        Label titleLabel = new Label("Create Event");
        titleLabel.setLayoutX(14.0);
        titleLabel.setLayoutY(14.0);
        titleLabel.setPrefWidth(159.0);
        titleLabel.setPrefHeight(35.0);
        titleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        titleLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        titleLabel.setFont(new Font("System Bold", 24.0));
        root.getChildren().add(titleLabel);

        Label dateLabel = new Label("Date");
        dateLabel.setLayoutX(13.0);
        dateLabel.setLayoutY(300.0);
        dateLabel.setPrefWidth(98.0);
        dateLabel.setPrefHeight(20.0);
        dateLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        dateLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        dateLabel.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(dateLabel);

        Label locationLabel = new Label("Location");
        locationLabel.setLayoutX(13.0);
        locationLabel.setLayoutY(340.0);
        locationLabel.setPrefWidth(98.0);
        locationLabel.setPrefHeight(20.0);
        locationLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        locationLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        locationLabel.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(locationLabel);

        Label nameLabel = new Label("Name");
        nameLabel.setLayoutX(14.0);
        nameLabel.setLayoutY(262.0);
        nameLabel.setPrefWidth(52.0);
        nameLabel.setPrefHeight(20.0);
        nameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        nameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        nameLabel.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(nameLabel);

        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setLayoutX(125.0);
        descriptionTextArea.setLayoutY(415.0);
        descriptionTextArea.setPrefWidth(451.0);
        descriptionTextArea.setPrefHeight(74.0);
        descriptionTextArea.setPromptText("e.x. Location / Notes / Guide Lines for Event");
        descriptionTextArea.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        root.getChildren().add(descriptionTextArea);

        Button createEventButton = new Button("Create Event");
        createEventButton.setLayoutX(488.0);
        createEventButton.setLayoutY(500.0);
        createEventButton.setMnemonicParsing(false);
        createEventButton.setPrefWidth(314.0);
        createEventButton.setPrefHeight(35.0);
        createEventButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        createEventButton.setTextFill(javafx.scene.paint.Color.WHITE);
        createEventButton.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(createEventButton);

        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(125.0);
        datePicker.setLayoutY(296.0);
        datePicker.setPrefWidth(451.0);
        datePicker.setPrefHeight(27.0);
        datePicker.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        root.getChildren().add(datePicker);

        ImageView imageView2 = new ImageView();
        imageView2.setImage(back);
        imageView2.setFitWidth(789.0);
        imageView2.setFitHeight(193.0);
        imageView2.setLayoutX(14.0);
        imageView2.setLayoutY(49.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(false);
        root.getChildren().add(imageView2);

        Label noOfTicketsLabel = new Label("No Of Tickets");
        noOfTicketsLabel.setLayoutX(13.0);
        noOfTicketsLabel.setLayoutY(379.0);
        noOfTicketsLabel.setPrefWidth(98.0);
        noOfTicketsLabel.setPrefHeight(20.0);
        noOfTicketsLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        noOfTicketsLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        noOfTicketsLabel.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(noOfTicketsLabel);

        Label priceLabel = new Label("Price");
        priceLabel.setLayoutX(330.0);
        priceLabel.setLayoutY(379.0);
        priceLabel.setPrefWidth(52.0);
        priceLabel.setPrefHeight(20.0);
        priceLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        priceLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        priceLabel.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(priceLabel);

        Label descriptionLabel = new Label("Description");
        descriptionLabel.setLayoutX(13.0);
        descriptionLabel.setLayoutY(415.0);
        descriptionLabel.setPrefWidth(98.0);
        descriptionLabel.setPrefHeight(20.0);
        descriptionLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        descriptionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        descriptionLabel.setFont(new Font("System Bold", 14.0));
        root.getChildren().add(descriptionLabel);

        TextField nameTextField = new TextField();
        nameTextField.setLayoutX(125.0);
        nameTextField.setLayoutY(258.0);
        nameTextField.setPrefWidth(451.0);
        nameTextField.setPrefHeight(27.0);
        nameTextField.setStyle("-fx-background-color: WHITE; -fx-border-radius: 5px; -fx-border-color: #343e7c;");
        root.getChildren().add(nameTextField);

        TextField locationTextField = new TextField();
        locationTextField.setLayoutX(125.0);
        locationTextField.setLayoutY(336.0);
        locationTextField.setPrefWidth(451.0);
        locationTextField.setPrefHeight(27.0);
        locationTextField.setStyle("-fx-background-color: WHITE; -fx-border-radius: 5px; -fx-border-color: #343e7c;");
        root.getChildren().add(locationTextField);

        TextField noOfTicketsTextField = new TextField();
        noOfTicketsTextField.setLayoutX(125.0);
        noOfTicketsTextField.setLayoutY(376.0);
        noOfTicketsTextField.setPrefWidth(178.0);
        noOfTicketsTextField.setPrefHeight(27.0);
        noOfTicketsTextField.setStyle("-fx-background-color: WHITE; -fx-border-radius: 5px; -fx-border-color: #343e7c;");
        root.getChildren().add(noOfTicketsTextField);

        TextField priceTextField = new TextField();
        priceTextField.setLayoutX(385.0);
        priceTextField.setLayoutY(376.0);
        priceTextField.setPrefWidth(190.0);
        priceTextField.setPrefHeight(27.0);
        priceTextField.setStyle("-fx-background-color: WHITE; -fx-border-radius: 5px; -fx-border-color: #343e7c;");
        root.getChildren().add(priceTextField);

        createEventButton.setOnAction(e->{
            String response = SingletonTicketingSystemController.getInstance().createEvent(nameTextField.getText(), locationTextField.getText(), datePicker.getValue()==null ? null : Date.valueOf(datePicker.getValue()), noOfTicketsTextField.getText(), priceTextField.getText(), descriptionTextArea.getText());
            if (response.equals("Success")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(response);
                alert.setHeaderText(response);
                alert.setContentText("Event Created Successfully");
                alert.showAndWait();
                EventsPage ep = new EventsPage();
                ep.start(primaryStage);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Can Not Add Event");
                alert.setContentText(response);
                alert.showAndWait();
            }
        });
        primaryStage.setCenter(root);
    }

}
