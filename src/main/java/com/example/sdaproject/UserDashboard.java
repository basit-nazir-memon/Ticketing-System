package com.example.sdaproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class UserDashboard {
    public void start(BorderPane primaryStage) {

        File file = new File("src/images/userDashboard.png");
        Image image = new Image(file.toURI().toString());

        AnchorPane root = new AnchorPane();
        root.setPrefSize(820.0, 550.0);
        root.setStyle("-fx-background-color: white;");

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setLayoutX(27.0);
        dashboardLabel.setLayoutY(21.0);
        dashboardLabel.setTextFill(Paint.valueOf("#363e7c"));
        dashboardLabel.setFont(Font.font("System Bold Italic", 18.0));
        AnchorPane.setLeftAnchor(dashboardLabel, 27.0);
        AnchorPane.setTopAnchor(dashboardLabel, 21.0);

        Pane pane1 = new Pane();
        pane1.setLayoutX(25.0);
        pane1.setLayoutY(55.0);
        pane1.setPrefSize(770.0, 108.0);
        pane1.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
        AnchorPane.setLeftAnchor(pane1, 25.0);
        AnchorPane.setRightAnchor(pane1, 25.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(97.0);
        imageView.setFitWidth(214.0);
        imageView.setLayoutX(542.0);
        imageView.setLayoutY(6.0);
        imageView.setPreserveRatio(true);
        imageView.setImage(image);
        pane1.getChildren().add(imageView);

        Label welcomeLabel = new Label("Welcome back! ");
        welcomeLabel.setLayoutX(24.0);
        welcomeLabel.setLayoutY(34.0);
        welcomeLabel.setTextFill(Paint.valueOf("#343e7c"));
        welcomeLabel.setFont(Font.font(13.0));
        pane1.getChildren().add(welcomeLabel);

        Label nameLabel = new Label(SessionStorage.getInstance().getUser().getFirstName() + " " +SessionStorage.getInstance().getUser().getLastName());
        nameLabel.setLayoutX(117.0);
        nameLabel.setLayoutY(29.0);
        nameLabel.setTextFill(Paint.valueOf("#ed7d29"));
        nameLabel.setFont(Font.font("System Bold Italic", FontWeight.BOLD ,18.0));
        pane1.getChildren().add(nameLabel);

        Label bookTicketsLabel = new Label("Book the tickets now with Ticket Lelo");
        bookTicketsLabel.setLayoutX(24.0);
        bookTicketsLabel.setLayoutY(62.0);
        bookTicketsLabel.setTextFill(Paint.valueOf("#343e7c"));
        bookTicketsLabel.setFont(Font.font(14.0));
        pane1.getChildren().add(bookTicketsLabel);

        Pane pane2 = new Pane();
        pane2.setLayoutX(25.0);
        pane2.setLayoutY(173.0);
        pane2.setPrefSize(240.0, 175.0);
        pane2.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
        AnchorPane.setLeftAnchor(pane2, 25.0);

        Label lbl1 = new Label("Clicks");
        lbl1.setLayoutX(10.0);
        lbl1.setLayoutY(5.0);
        lbl1.setTextFill(Paint.valueOf("#343e7c"));
        lbl1.setFont(Font.font("System Bold",FontWeight.BOLD ,14.0));
        pane2.getChildren().add(lbl1);

        BarChart<String, Number> barChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        barChart.setLayoutX(5.0);
        barChart.setLayoutY(30.0);
        barChart.setPrefWidth(230);
        barChart.setPrefHeight(140);
        pane2.getChildren().add(barChart);

        Pane pane3 = new Pane();
        pane3.setLayoutX(276.0);
        pane3.setLayoutY(173.0);
        pane3.setPrefSize(240.0, 175.0);
        pane3.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label lbl2 = new Label("Traffic");
        lbl2.setLayoutX(10.0);
        lbl2.setLayoutY(5.0);
        lbl2.setTextFill(Paint.valueOf("#343e7c"));
        lbl2.setFont(Font.font("System Bold",FontWeight.BOLD ,14.0));
        pane3.getChildren().add(lbl2);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Iphone 5S", 13),
                new PieChart.Data("Samsung Grand", 25),
                new PieChart.Data("MOTO G", 10),
                new PieChart.Data("Nokia Lumia", 22));

        PieChart pieChart = new PieChart();
        pieChart.setLayoutX(15.0);
        pieChart.setLayoutY(20.0);
        pieChart.setPrefSize(147,127);
        pieChart.setData(pieChartData);
        pane3.getChildren().add(pieChart);

        Pane pane4 = new Pane();
        pane4.setLayoutX(529.0);
        pane4.setLayoutY(173.0);
        pane4.setPrefSize(265.0, 350.0);
        pane4.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
        AnchorPane.setBottomAnchor(pane4, 26.600000000000023);
        AnchorPane.setRightAnchor(pane4, 25.0);

        Label lbl3 = new Label("Events");
        lbl3.setLayoutX(10.0);
        lbl3.setLayoutY(5.0);
        lbl3.setTextFill(Paint.valueOf("#343e7c"));
        lbl3.setFont(Font.font("System Bold",FontWeight.BOLD ,14.0));
        pane4.getChildren().add(lbl3);

        Pane subPane1 = new Pane();
        subPane1.setLayoutX(13.0);
        subPane1.setLayoutY(46.0);
        subPane1.setPrefSize(240.0, 136.0);
        subPane1.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
        pane4.getChildren().add(subPane1);

        File file1 = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file1.toURI().toString());

        ImageView imageView1 = new ImageView();
        imageView1.setFitHeight(136.0);
        imageView1.setFitWidth(240.0);
        imageView1.setImage(back);
        imageView1.setPreserveRatio(false);
        subPane1.getChildren().add(imageView1);

        Button bookButton1 = new Button("Book");
        bookButton1.setLayoutX(155.0);
        bookButton1.setLayoutY(104.0);
        bookButton1.setPrefWidth(80);
        bookButton1.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        bookButton1.setTextFill(Paint.valueOf("#343e7c"));
        subPane1.getChildren().add(bookButton1);

        Pane subPane2 = new Pane();
        subPane2.setLayoutX(13.0);
        subPane2.setLayoutY(194.0);
        subPane2.setPrefSize(240.0, 136.0);
        subPane2.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White; ");
        pane4.getChildren().add(subPane2);

        ImageView imageView2 = new ImageView();
        imageView2.setFitHeight(136.0);
        imageView2.setFitWidth(240.0);
        imageView2.setImage(back);
        imageView2.setPreserveRatio(false);
        subPane2.getChildren().add(imageView2);

        Button bookButton2 = new Button("Book");
        bookButton2.setLayoutX(155.0);
        bookButton2.setLayoutY(104.0);
        bookButton2.setPrefWidth(80);
        bookButton2.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        bookButton2.setTextFill(Paint.valueOf("#343e7c"));
        subPane2.getChildren().add(bookButton2);

        Pane pane5 = new Pane();
        pane5.setLayoutX(27.0);
        pane5.setLayoutY(358.0);
        pane5.setPrefSize(155.0, 166.0);
        pane5.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label lbl5 = new Label("Bookings");
        lbl5.setLayoutX(10.0);
        lbl5.setLayoutY(5.0);
        lbl5.setTextFill(Paint.valueOf("#343e7c"));
        lbl5.setFont(Font.font("System Bold",FontWeight.BOLD ,14.0));
        pane5.getChildren().add(lbl5);

        Label bookingsLabel1 = new Label("10");
        bookingsLabel1.setLayoutY(51.0);
        bookingsLabel1.setPrefSize(155.0, 53.0);
        bookingsLabel1.setStyle("-fx-alignment: center;");
        bookingsLabel1.setTextFill(Paint.valueOf("#ed7d29"));
        bookingsLabel1.setFont(Font.font("System Bold Italic", FontWeight.BOLD,36.0));
        pane5.getChildren().add(bookingsLabel1);

        Button viewBookingsButton1 = new Button("View Bookings");
        viewBookingsButton1.setLayoutX(15.0);
        viewBookingsButton1.setLayoutY(127.0);
        viewBookingsButton1.setPrefWidth(125);
        viewBookingsButton1.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        viewBookingsButton1.setTextFill(Paint.valueOf("#343e7c"));
        pane5.getChildren().add(viewBookingsButton1);

        viewBookingsButton1.setOnMouseEntered(e->{
            viewBookingsButton1.setStyle("-fx-background-color: #343e7c; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
            viewBookingsButton1.setTextFill(Paint.valueOf("#fff"));
        });

        viewBookingsButton1.setOnMouseExited(e->{
            viewBookingsButton1.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
            viewBookingsButton1.setTextFill(Paint.valueOf("#343e7c"));
        });

        Pane pane6 = new Pane();
        pane6.setLayoutX(194.0);
        pane6.setLayoutY(358.0);
        pane6.setPrefSize(155.0, 166.0);
        pane6.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label lbl6 = new Label("Coupons");
        lbl6.setLayoutX(10.0);
        lbl6.setLayoutY(5.0);
        lbl6.setTextFill(Paint.valueOf("#343e7c"));
        lbl6.setFont(Font.font("System Bold",FontWeight.BOLD ,14.0));
        pane6.getChildren().add(lbl6);

        Label bookingsLabel2 = new Label("10");
        bookingsLabel2.setLayoutY(51.0);
        bookingsLabel2.setPrefSize(155.0, 53.0);
        bookingsLabel2.setStyle("-fx-alignment: center;");
        bookingsLabel2.setTextFill(Paint.valueOf("#ed7d29"));
        bookingsLabel2.setFont(Font.font("System Bold Italic",FontWeight.BOLD, 36.0));
        pane6.getChildren().add(bookingsLabel2);

        Button viewBookingsButton2 = new Button("View Coupons");
        viewBookingsButton2.setLayoutX(15.0);
        viewBookingsButton2.setLayoutY(127.0);
        viewBookingsButton2.setPrefWidth(125);
        viewBookingsButton2.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        viewBookingsButton2.setTextFill(Paint.valueOf("#343e7c"));
        pane6.getChildren().add(viewBookingsButton2);

        viewBookingsButton2.setOnMouseEntered(e->{
            viewBookingsButton2.setStyle("-fx-background-color: #343e7c; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
            viewBookingsButton2.setTextFill(Paint.valueOf("#fff"));
        });

        viewBookingsButton2.setOnMouseExited(e->{
            viewBookingsButton2.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
            viewBookingsButton2.setTextFill(Paint.valueOf("#343e7c"));
        });

        Pane pane7 = new Pane();
        pane7.setLayoutX(360.0);
        pane7.setLayoutY(358.0);
        pane7.setPrefSize(155.0, 166.0);
        pane7.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");

        Label lbl7 = new Label("Campaigns");
        lbl7.setLayoutX(10.0);
        lbl7.setLayoutY(5.0);
        lbl7.setTextFill(Paint.valueOf("#343e7c"));
        lbl7.setFont(Font.font("System Bold",FontWeight.BOLD ,14.0));
        pane7.getChildren().add(lbl7);

        Label bookingsLabel3 = new Label("10");
        bookingsLabel3.setLayoutY(51.0);
        bookingsLabel3.setPrefSize(155.0, 53.0);
        bookingsLabel3.setStyle("-fx-alignment: center;");
        bookingsLabel3.setTextFill(Paint.valueOf("#ed7d29"));
        bookingsLabel3.setFont(Font.font("System Bold Italic", FontWeight.BOLD, 36.0));
        pane7.getChildren().add(bookingsLabel3);

        Button viewBookingsButton3 = new Button("View Campaigns");
        viewBookingsButton3.setLayoutX(15.0);
        viewBookingsButton3.setLayoutY(127.0);
        viewBookingsButton3.setPrefWidth(125);
        viewBookingsButton3.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        viewBookingsButton3.setTextFill(Paint.valueOf("#343e7c"));
        pane7.getChildren().add(viewBookingsButton3);

        viewBookingsButton3.setOnMouseEntered(e->{
            viewBookingsButton3.setStyle("-fx-background-color: #343e7c; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
            viewBookingsButton3.setTextFill(Paint.valueOf("#fff"));
        });

        viewBookingsButton3.setOnMouseExited(e->{
            viewBookingsButton3.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
            viewBookingsButton3.setTextFill(Paint.valueOf("#343e7c"));
        });

        root.getChildren().addAll(dashboardLabel, pane1, pane2, pane3, pane4, pane5, pane6, pane7);

        primaryStage.setCenter(root);
    }

}
