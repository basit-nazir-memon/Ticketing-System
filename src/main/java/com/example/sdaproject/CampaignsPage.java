package com.example.sdaproject;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class CampaignsPage {
    ArrayList<Campaign> campaigns;
    HashMap<Campaign, Event> map;

    public void start(BorderPane primaryStage) {
        campaigns = SingletonTicketingSystemController.getInstance().getCampaigns();
        map = SingletonTicketingSystemController.getInstance().getCampaignMap();


        File file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(820.0, 550.0);
        anchorPane.setStyle("-fx-background-color: white;");

        Button backButton = new Button("< Back");
        backButton.setLayoutX(3.0);
        backButton.setLayoutY(4.0);
        backButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");

        Label campaignsLabel = new Label("Campaigns");
        campaignsLabel.setLayoutX(19.0);
        campaignsLabel.setLayoutY(38.0);
        campaignsLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        campaignsLabel.setFont(new Font("System Bold Italic", 28.0));

        int i = 0;
        for (Campaign c : campaigns) {
            Pane pane = new Pane();
            pane.setLayoutX(20.0);
            pane.setLayoutY(85.0 + i*55);
            pane.setPrefSize(779.0, 50.0);
            pane.setStyle("-fx-border-radius: 15px; -fx-border-color: #363e7c; -fx-background-color: White;");
            AnchorPane.setLeftAnchor(pane, 20.0);
            AnchorPane.setRightAnchor(pane, 20.0);

            Label eventNameLabel = new Label(map.get(c).getName());
            eventNameLabel.setLayoutX(73.0);
            eventNameLabel.setLayoutY(15.0);
            eventNameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            eventNameLabel.setFont(new Font("System Bold", 14.0));

            ImageView imageView = new ImageView();
            imageView.setFitHeight(40.0);
            imageView.setFitWidth(40.0);
            imageView.setLayoutX(14.0);
            imageView.setLayoutY(5.0);
            imageView.setPickOnBounds(true);
            imageView.setImage(back);
            imageView.setPreserveRatio(false);

            Button viewButton = new Button("View");
            viewButton.setLayoutX(673.0);
            viewButton.setLayoutY(9.0);
            viewButton.setPrefWidth(95);
            viewButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
            viewButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            viewButton.setFont(new Font(13.0));


            viewButton.setOnMouseEntered(e -> {
                viewButton.setStyle("-fx-background-color: #343e7c; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px; -fx-background-radius: 10px;");
                viewButton.setTextFill(javafx.scene.paint.Color.web("#fff"));
            });

            viewButton.setOnMouseExited(e -> {
                viewButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
                viewButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
            });

            viewButton.setOnAction(e -> {
                CampaignInfo ci = new CampaignInfo();
                ci.setEvent(map.get(c));
                ci.setCam(c);
                ci.start(primaryStage);
            });

            if (!SingletonTicketingSystem.getInstance().getLoggedInUser().getRole().equals("Customer")) {
                Button editButton = new Button("Edit");
                editButton.setLayoutX(572.0);
                editButton.setLayoutY(9.0);
                editButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
                editButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
                editButton.setPrefWidth(95);
                editButton.setFont(new Font(13.0));

                editButton.setOnMouseEntered(e -> {
                    editButton.setStyle("-fx-background-color: #ed7d29; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px; -fx-background-radius: 10px;");
                    editButton.setTextFill(javafx.scene.paint.Color.web("#fff"));
                });

                editButton.setOnMouseExited(e -> {
                    editButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
                    editButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
                });

                editButton.setOnAction(e -> {
                    EditCampaignPage ecp = new EditCampaignPage();
                    ecp.setEvent(map.get(c));
                    ecp.setCam(c);
                    ecp.start(primaryStage);

                });
                pane.getChildren().add(editButton);
                i++;
            }

            pane.getChildren().addAll(eventNameLabel, imageView, viewButton);

            anchorPane.getChildren().add(pane);
        }
        ComboBox<String> sortByComboBox = new ComboBox<>();
        sortByComboBox.setLayoutX(542.0);
        sortByComboBox.setLayoutY(45.0);
        sortByComboBox.setPrefSize(89.0, 27.0);
        sortByComboBox.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-border-radius: 5px;");

        Label sortByLabel = new Label("Sort By");
        sortByLabel.setLayoutX(486.0);
        sortByLabel.setLayoutY(49.0);
        sortByLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        sortByLabel.setFont(new Font("System Bold", 14.0));

        Label filtersLabel = new Label("Filters");
        filtersLabel.setLayoutX(655.0);
        filtersLabel.setLayoutY(49.0);
        filtersLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        filtersLabel.setFont(new Font("System Bold", 14.0));

        ChoiceBox<String> filtersChoiceBox = new ChoiceBox<>();
        filtersChoiceBox.setLayoutX(705.0);
        filtersChoiceBox.setLayoutY(47.0);
        filtersChoiceBox.setPrefSize(90.0, 26.0);
        filtersChoiceBox.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-border-radius: 5px;");

        anchorPane.getChildren().addAll(backButton, campaignsLabel, sortByComboBox, sortByLabel, filtersLabel, filtersChoiceBox);

        primaryStage.setCenter(anchorPane);
    }
}
