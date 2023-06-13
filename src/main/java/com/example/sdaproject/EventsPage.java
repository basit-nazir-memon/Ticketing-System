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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class EventsPage{

    ArrayList<Event> eventList;

    public void start(BorderPane primaryStage) {
        eventList = SingletonTicketingSystemController.getInstance().getEvents();

        File file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());


        AnchorPane root = new AnchorPane();
        root.setMaxHeight(Double.NEGATIVE_INFINITY);
        root.setMaxWidth(Double.NEGATIVE_INFINITY);
        root.setMinHeight(Double.NEGATIVE_INFINITY);
        root.setMinWidth(Double.NEGATIVE_INFINITY);
        root.setPrefHeight(550.0);
        root.setPrefWidth(820.0);
        root.setStyle("-fx-background-color: white;");

        Label labelEvents = new Label("Events");
        labelEvents.setLayoutX(22.0);
        labelEvents.setLayoutY(13.0);
        labelEvents.setTextFill(Color.web("#363e7c"));
        labelEvents.setFont(Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC, 24.0));
        AnchorPane.setLeftAnchor(labelEvents, 22.0);
        AnchorPane.setTopAnchor(labelEvents, 13.0);
        root.getChildren().add(labelEvents);


        for (int i = 0; i< eventList.size(); i++) {
            Pane paneEvent = new Pane();
            paneEvent.setLayoutX(14.0 + (i%3)*265);
            paneEvent.setLayoutY(67.0 + (i/3)*230);
            paneEvent.setPrefHeight(220.0);
            paneEvent.setPrefWidth(255.0);
            paneEvent.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
            root.getChildren().add(paneEvent);

            ImageView imageViewEvent = new ImageView();
            imageViewEvent.setFitHeight(111.0);
            imageViewEvent.setFitWidth(255.0);
            imageViewEvent.setImage(back);
            imageViewEvent.setPickOnBounds(true);
            imageViewEvent.setPreserveRatio(false);
            imageViewEvent.setStyle("-fx-border-radius: 10px 10px 0px 0px;");
            paneEvent.getChildren().add(imageViewEvent);

            Label labelEventTitle = new Label(eventList.get(i).getName());
            labelEventTitle.setLayoutX(6.0);
            labelEventTitle.setLayoutY(114.0);
            labelEventTitle.setMinWidth(245.0);
            labelEventTitle.setTextFill(Color.web("#ed7d29"));
            labelEventTitle.setFont(Font.font("System Bold", FontWeight.BOLD, 14.0));
            paneEvent.getChildren().add(labelEventTitle);

            Label labelEventDate = new Label(eventList.get(i).getDate().toString());
            labelEventDate.setLayoutX(9.0);
            labelEventDate.setLayoutY(134.0);
            labelEventDate.setTextFill(Color.web("#343e7c"));
            labelEventDate.setFont(Font.font("System Italic", FontPosture.ITALIC, 12.0));
            paneEvent.getChildren().add(labelEventDate);

            Label labelEventLocation = new Label(eventList.get(i).getLocation());
            labelEventLocation.setLayoutX(10.0);
            labelEventLocation.setLayoutY(151.0);
            labelEventLocation.setTextFill(Color.web("#343e7c"));
            labelEventLocation.setFont(Font.font("System Italic", FontPosture.ITALIC, 12.0));
            paneEvent.getChildren().add(labelEventLocation);

            Label labelCurrency = new Label("PKR");
            labelCurrency.setLayoutX(161.0);
            labelCurrency.setLayoutY(186.0);
            labelCurrency.setTextFill(Color.web("#343e7c"));
            paneEvent.getChildren().add(labelCurrency);

            Label labelTicketPrice = new Label(Integer.toString(eventList.get(i).getPrice()));
            labelTicketPrice.setLayoutX(188.0);
            labelTicketPrice.setLayoutY(180.0);
            labelTicketPrice.setTextFill(Color.web("#343e7c"));
            labelTicketPrice.setFont(Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC, 24.0));
            paneEvent.getChildren().add(labelTicketPrice);

            Button buttonBookTickets = new Button("Book Tickets");
            buttonBookTickets.setLayoutX(8.0);
            buttonBookTickets.setLayoutY(185.0);
            buttonBookTickets.setMnemonicParsing(false);
            buttonBookTickets.setPrefHeight(27.0);
            buttonBookTickets.setPrefWidth(123.0);
            buttonBookTickets.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
            buttonBookTickets.setTextFill(Color.web("#343e7c"));
            buttonBookTickets.setOnMouseEntered(e->{
                buttonBookTickets.setStyle("-fx-background-color: #343e7c; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px");
                buttonBookTickets.setTextFill(Color.web("#fff"));
            });
            buttonBookTickets.setOnMouseExited(e->{
                buttonBookTickets.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
                buttonBookTickets.setTextFill(Color.web("#343e7c"));
            });
            int finalI = i;
            buttonBookTickets.setOnAction(e->{
                EventDetailsPage edp = new EventDetailsPage();
                edp.setEvent(eventList.get(finalI));
                edp.start(primaryStage);
            });
            paneEvent.getChildren().add(buttonBookTickets);

        }

        primaryStage.setCenter(root);
    }
}
