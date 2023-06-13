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

public class EventDetailsPage {
    private Event event;

    public void setEvent(Event event) {
        this.event = event;
    }

    public void start(BorderPane primaryStage) {

        File file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        AnchorPane root = new AnchorPane();
        root.setPrefSize(820.0, 550.0);
        root.setStyle("-fx-background-color: white;");

        Button backButton = new Button("< Back");
        backButton.setLayoutX(3.0);
        backButton.setLayoutY(4.0);
        backButton.setPrefSize(72.0, 27.0);
        backButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        backButton.setOnAction(e->{
            EventsPage ep = new EventsPage();
            ep.start(primaryStage);
        });

        ImageView imageView = new ImageView();
        imageView.setFitHeight(243.0);
        imageView.setFitWidth(800.0);
        imageView.setLayoutX(5.0);
        imageView.setLayoutY(64.0);
        imageView.setImage(back);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(false);
        AnchorPane.setLeftAnchor(imageView, 10.0);
        AnchorPane.setRightAnchor(imageView, 10.0);
        AnchorPane.setTopAnchor(imageView, 36.0);

        Label concertLabel = new Label(event.getName());
        concertLabel.setLayoutX(22.0);
        concertLabel.setLayoutY(279.0);
        concertLabel.setTextFill(javafx.scene.paint.Color.valueOf("#363e7c"));
        Font concertLabelFont = Font.font("System Bold Italic", 28.0);
        concertLabel.setFont(concertLabelFont);

        Pane eventPane = new Pane();
        eventPane.setLayoutX(507.0);
        eventPane.setLayoutY(300.0);
        eventPane.setPrefSize(298.0, 165.0);
        eventPane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
        AnchorPane.setBottomAnchor(eventPane, 84.60000000000002);

        Label eventDescriptionLabel = new Label("Event Description");
        eventDescriptionLabel.setLayoutX(12.0);
        eventDescriptionLabel.setLayoutY(7.0);
        eventDescriptionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventDescriptionFont = Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC,14.0);
        eventDescriptionLabel.setFont(eventDescriptionFont);

        Label eventLabel = new Label(event.getDescription());
        eventLabel.setLayoutX(14.0);
        eventLabel.setLayoutY(27.0);
        eventLabel.setMaxHeight(110.0);
        eventLabel.setMaxWidth(265.0);
        eventLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font eventFont = Font.font("System Italic", FontPosture.ITALIC,14.0);
        eventLabel.setFont(eventFont);

        eventPane.getChildren().addAll(eventDescriptionLabel, eventLabel);

        Label dateLabel = new Label(event.getDate().toString());
        dateLabel.setLayoutX(22.0);
        dateLabel.setLayoutY(320.0);
        dateLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font dateFont = Font.font("System Italic", FontPosture.ITALIC,14.0);
        dateLabel.setFont(dateFont);

        Label locationLabel = new Label(event.getLocation());
        locationLabel.setLayoutX(22.0);
        locationLabel.setLayoutY(347.0);
        locationLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font locationFont = Font.font("System Italic", FontPosture.ITALIC,14.0);
        locationLabel.setFont(locationFont);

        Button bookTicketsButton = new Button("Book Tickets");
        bookTicketsButton.setLayoutX(22.0);
        bookTicketsButton.setLayoutY(425.0);
        bookTicketsButton.setPrefSize(228.0, 40.0);
        bookTicketsButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        bookTicketsButton.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        bookTicketsButton.setOnAction(e->{
            TicketBookingInfoPage tbip = new TicketBookingInfoPage();
            tbip.setEvent(event);
            tbip.start(primaryStage);
        });


        Label priceLabel = new Label(Integer.toString(event.getPrice()));
        priceLabel.setLayoutX(47.0);
        priceLabel.setLayoutY(369.0);
        priceLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));
        Font priceFont = Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC, 24.0);
        priceLabel.setFont(priceFont);

        Label currencyLabel = new Label("PKR");
        currencyLabel.setLayoutX(22.0);
        currencyLabel.setLayoutY(375.0);
        currencyLabel.setTextFill(javafx.scene.paint.Color.valueOf("#343e7c"));

        root.getChildren().addAll(backButton, imageView, concertLabel, eventPane, dateLabel, locationLabel,
                bookTicketsButton, priceLabel, currencyLabel);

        primaryStage.setCenter(root);
    }

}
