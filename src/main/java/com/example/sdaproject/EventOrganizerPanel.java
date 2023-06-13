package com.example.sdaproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class EventOrganizerPanel extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setMaxHeight(Double.NEGATIVE_INFINITY);
        root.setMaxWidth(Double.NEGATIVE_INFINITY);
        root.setMinHeight(Double.NEGATIVE_INFINITY);
        root.setMinWidth(Double.NEGATIVE_INFINITY);
        root.setPrefHeight(600.0);
        root.setPrefWidth(1000.0);
        root.setStyle("-fx-background-color: White;");

        File file = new File("src/images/logo.png");
        Image image = new Image(file.toURI().toString());

        file = new File("src/images/frame.png");
        Image pic = new Image(file.toURI().toString());

        Pane topPane = new Pane();
        topPane.setPrefHeight(50.0);
        topPane.setPrefWidth(1000.0);
        topPane.setStyle("-fx-background-color: #f1f3ff;");
        

        ImageView logoImageView = new ImageView();
        logoImageView.setImage(image);
        logoImageView.setFitHeight(50.0);
        logoImageView.setFitWidth(180.0);
        logoImageView.setLayoutX(60.0);
        logoImageView.setLayoutY(0.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);

        topPane.getChildren().add(logoImageView);

        ImageView logoutImageView = new ImageView();
        logoutImageView.setImage(pic);
        logoutImageView.setFitHeight(39.0);
        logoutImageView.setFitWidth(42.0);
        logoutImageView.setLayoutX(951.0);
        logoutImageView.setLayoutY(5.0);
        logoutImageView.setPickOnBounds(true);
        logoutImageView.setPreserveRatio(true);

        topPane.getChildren().add(logoutImageView);

        root.setTop(topPane);

        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setPrefHeight(534.0);
        leftPane.setPrefWidth(180.0);
        leftPane.setStyle("-fx-background-color: #f1f3ff;");
        root.setLeft(leftPane);

        HBox dashboardBox = new HBox();
        dashboardBox.setAlignment(Pos.CENTER);
        dashboardBox.setPrefHeight(40.0);
        dashboardBox.setPrefWidth(180.0);

        dashboardBox.setOnMouseClicked(e->{
            UserDashboard ud = new UserDashboard();
            ud.start(root);
        });

        leftPane.getChildren().add(dashboardBox);

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setTextFill(Color.web("#343e7c"));
        dashboardLabel.setFont(new Font(14.0));
        dashboardBox.getChildren().add(dashboardLabel);

        dashboardBox.setOnMouseEntered(e->{
                dashboardBox.setStyle("-fx-background-color: #343e7c;");
                dashboardLabel.setTextFill(Color.WHITE);
        });

        dashboardBox.setOnMouseExited(e->{
                dashboardBox.setStyle("-fx-background-color: TRANSPARENT;");
                dashboardLabel.setTextFill(Color.web("#343e7c"));
        });

        HBox eventsBox = new HBox();
        eventsBox.setAlignment(Pos.CENTER);
        eventsBox.setLayoutX(10.0);
        eventsBox.setLayoutY(10.0);
        eventsBox.setPrefHeight(40.0);
        eventsBox.setPrefWidth(180.0);
        eventsBox.setOnMouseClicked(e->{
            EventsPage ep = new EventsPage();
            ep.start(root);
        });
        leftPane.getChildren().add(eventsBox);

        Label eventsLabel = new Label("Events");
        eventsLabel.setTextFill(Color.web("#343e7c"));
        eventsLabel.setFont(new Font(14.0));
        eventsBox.getChildren().add(eventsLabel);

        eventsBox.setOnMouseEntered(e->{
            eventsBox.setStyle("-fx-background-color: #343e7c;");
            eventsLabel.setTextFill(Color.WHITE);
        });

        eventsBox.setOnMouseExited(e->{
            eventsBox.setStyle("-fx-background-color: TRANSPARENT;");
            eventsLabel.setTextFill(Color.web("#343e7c"));
        });

        HBox bookingsBox = new HBox();
        bookingsBox.setAlignment(Pos.CENTER);
        bookingsBox.setLayoutX(10.0);
        bookingsBox.setLayoutY(50.0);
        bookingsBox.setPrefHeight(40.0);
        bookingsBox.setPrefWidth(180.0);
        leftPane.getChildren().add(bookingsBox);

        Label bookingsLabel = new Label("Bookings");
        bookingsLabel.setTextFill(Color.web("#343e7c"));
        bookingsLabel.setFont(new Font(14.0));
        bookingsBox.getChildren().add(bookingsLabel);

        bookingsBox.setOnMouseClicked(e->{
            BookingsPage bp = new BookingsPage();
            bp.start(root);
        });

        bookingsBox.setOnMouseEntered(e->{
            bookingsBox.setStyle("-fx-background-color: #343e7c;");
            bookingsLabel.setTextFill(Color.WHITE);
        });

        bookingsBox.setOnMouseExited(e->{
            bookingsBox.setStyle("-fx-background-color: TRANSPARENT;");
            bookingsLabel.setTextFill(Color.web("#343e7c"));
        });

        HBox campaignsBox = new HBox();
        campaignsBox.setAlignment(Pos.CENTER);
        campaignsBox.setLayoutX(10.0);
        campaignsBox.setLayoutY(90.0);
        campaignsBox.setPrefHeight(40.0);
        campaignsBox.setPrefWidth(180.0);
        leftPane.getChildren().add(campaignsBox);

        Label campaignsLabel = new Label("Campaigns");
        campaignsLabel.setTextFill(Color.web("#343e7c"));
        campaignsLabel.setFont(new Font(14.0));
        campaignsBox.getChildren().add(campaignsLabel);

        campaignsBox.setOnMouseClicked(e->{
            CampaignsMain cp = new CampaignsMain();
            cp.start(root);
        });

        campaignsBox.setOnMouseEntered(e->{
            campaignsBox.setStyle("-fx-background-color: #343e7c;");
            campaignsLabel.setTextFill(Color.WHITE);
        });

        campaignsBox.setOnMouseExited(e->{
            campaignsBox.setStyle("-fx-background-color: TRANSPARENT;");
            campaignsLabel.setTextFill(Color.web("#343e7c"));
        });

        HBox walletBox = new HBox();
        walletBox.setAlignment(Pos.CENTER);
        walletBox.setLayoutX(10.0);
        walletBox.setLayoutY(130.0);
        walletBox.setPrefHeight(40.0);
        walletBox.setPrefWidth(180.0);
        leftPane.getChildren().add(walletBox);

        Label walletLabel = new Label("Wallet");
        walletLabel.setTextFill(Color.web("#343e7c"));
        walletLabel.setFont(new Font(14.0));
        walletBox.getChildren().add(walletLabel);

        walletBox.setOnMouseEntered(e->{
            walletBox.setStyle("-fx-background-color: #343e7c;");
            walletLabel.setTextFill(Color.WHITE);
        });

        walletBox.setOnMouseExited(e->{
            walletBox.setStyle("-fx-background-color: TRANSPARENT;");
            walletLabel.setTextFill(Color.web("#343e7c"));
        });

        walletBox.setOnMouseClicked(e->{
            WalletPage wp = new WalletPage();
            wp.start(root);
        });

        HBox profileBox = new HBox();
        profileBox.setAlignment(Pos.CENTER);
        profileBox.setLayoutX(10.0);
        profileBox.setLayoutY(170.0);
        profileBox.setPrefHeight(40.0);
        profileBox.setPrefWidth(180.0);
        leftPane.getChildren().add(profileBox);

        Label profileLabel = new Label("Profile");
        profileLabel.setTextFill(Color.web("#343e7c"));
        profileLabel.setFont(new Font(14.0));
        profileBox.getChildren().add(profileLabel);

        profileBox.setOnMouseClicked(e->{
            ProfilePage pp = new ProfilePage();
            pp.start(root);
        });

        profileBox.setOnMouseEntered(e->{
            profileBox.setStyle("-fx-background-color: #343e7c;");
            profileLabel.setTextFill(Color.WHITE);
        });

        profileBox.setOnMouseExited(e->{
            profileBox.setStyle("-fx-background-color: TRANSPARENT;");
            profileLabel.setTextFill(Color.web("#343e7c"));
        });

        HBox settingsBox = new HBox();
        settingsBox.setAlignment(Pos.CENTER);
        settingsBox.setLayoutX(10.0);
        settingsBox.setLayoutY(210.0);
        settingsBox.setPrefHeight(40.0);
        settingsBox.setPrefWidth(180.0);
        leftPane.getChildren().add(settingsBox);

        Label settingsLabel = new Label("Coupons");
        settingsLabel.setTextFill(Color.web("#343e7c"));
        settingsLabel.setFont(new Font(14.0));
        settingsBox.getChildren().add(settingsLabel);

        settingsBox.setOnMouseEntered(e->{
            settingsBox.setStyle("-fx-background-color: #343e7c;");
            settingsLabel.setTextFill(Color.WHITE);
        });

        settingsBox.setOnMouseExited(e->{
            settingsBox.setStyle("-fx-background-color: TRANSPARENT;");
            settingsLabel.setTextFill(Color.web("#343e7c"));
        });

        settingsBox.setOnMouseClicked(e->{
            CouponsMain cp = new CouponsMain();
            cp.start(root);
        });

        HBox logoutBox = new HBox();
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setLayoutX(10.0);
        logoutBox.setLayoutY(330.0);
        logoutBox.setPrefHeight(40.0);
        logoutBox.setPrefWidth(180.0);
        leftPane.getChildren().add(logoutBox);

        Label logoutLabel = new Label("LogOut");
        logoutLabel.setTextFill(Color.web("#343e7c"));
        logoutLabel.setFont(new Font(14.0));
        logoutBox.getChildren().add(logoutLabel);

        logoutBox.setOnMouseEntered(e->{
            logoutBox.setStyle("-fx-background-color: #343e7c;");
            logoutLabel.setTextFill(Color.WHITE);
        });

        logoutBox.setOnMouseExited(e->{
            logoutBox.setStyle("-fx-background-color: TRANSPARENT;");
            logoutLabel.setTextFill(Color.web("#343e7c"));
        });

        logoutBox.setOnMouseClicked(e->{
            Login l = new Login();
            try {
                l.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });


        HBox createEvents = new HBox();
        createEvents.setAlignment(Pos.CENTER);
        createEvents.setLayoutX(10.0);
        createEvents.setLayoutY(290.0);
        createEvents.setPrefHeight(40.0);
        createEvents.setPrefWidth(180.0);
        leftPane.getChildren().add(createEvents);

        Label createEventsLabel = new Label("Create Events");
        createEventsLabel.setTextFill(Color.web("#343e7c"));
        createEventsLabel.setFont(new Font(14.0));
        createEvents.getChildren().add(createEventsLabel);

        createEvents.setOnMouseEntered(e->{
            createEvents.setStyle("-fx-background-color: #343e7c;");
            createEventsLabel.setTextFill(Color.WHITE);
        });

        createEvents.setOnMouseExited(e->{
            createEvents.setStyle("-fx-background-color: TRANSPARENT;");
            createEventsLabel.setTextFill(Color.web("#343e7c"));
        });

        createEvents.setOnMouseClicked(e->{
            CreateEventPage cp = new CreateEventPage();
            cp.start(root);
        });


        HBox settingsBox1 = new HBox();
        settingsBox1.setAlignment(Pos.CENTER);
        settingsBox1.setLayoutX(10.0);
        settingsBox1.setLayoutY(250.0);
        settingsBox1.setPrefHeight(40.0);
        settingsBox1.setPrefWidth(180.0);
        leftPane.getChildren().add(settingsBox1);

        Label settingsLabel1 = new Label("Support");
        settingsLabel1.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        settingsLabel1.setFont(new Font(14.0));
        settingsBox1.getChildren().add(settingsLabel1);

        settingsBox1.setOnMouseEntered(e->{
            settingsBox1.setStyle("-fx-background-color: #343e7c;");
            settingsLabel1.setTextFill(Color.WHITE);
        });

        settingsBox1.setOnMouseExited(e->{
            settingsBox1.setStyle("-fx-background-color: TRANSPARENT;");
            settingsLabel1.setTextFill(Color.web("#343e7c"));
        });

        settingsBox1.setOnMouseClicked(e->{
            SettingsPage sp = new SettingsPage();
            sp.start(root);
        });


        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

