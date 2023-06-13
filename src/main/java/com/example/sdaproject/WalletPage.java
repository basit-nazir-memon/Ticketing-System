package com.example.sdaproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class WalletPage{
    public void start(BorderPane primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setMaxHeight(Double.NEGATIVE_INFINITY);
        anchorPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        anchorPane.setMinHeight(Double.NEGATIVE_INFINITY);
        anchorPane.setMinWidth(Double.NEGATIVE_INFINITY);
        anchorPane.setPrefHeight(550.0);
        anchorPane.setPrefWidth(820.0);
        anchorPane.setStyle("-fx-background-color: white;");

        Label walletLabel = new Label("Wallet");
        walletLabel.setLayoutX(11.0);
        walletLabel.setLayoutY(6.0);
        walletLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        walletLabel.setFont(Font.font("System Bold Italic", FontWeight.BOLD, FontPosture.ITALIC,28.0));

        Button viewAllButton = new Button("View All");
        viewAllButton.setLayoutX(733.0);
        viewAllButton.setLayoutY(173.0);
        viewAllButton.setMnemonicParsing(false);
        viewAllButton.setPrefHeight(21.0);
        viewAllButton.setPrefWidth(72.0);
        viewAllButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
        viewAllButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        viewAllButton.setFont(Font.font("System Bold", FontWeight.BOLD, 12.0));

        Pane balancePane = new Pane();
        balancePane.setLayoutX(17.0);
        balancePane.setLayoutY(57.0);
        balancePane.setPrefHeight(102.0);
        balancePane.setPrefWidth(786.0);
        balancePane.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");
        AnchorPane.setLeftAnchor(balancePane, 17.0);

        Label balanceLabel = new Label("Balance");
        balanceLabel.setLayoutX(14.0);
        balanceLabel.setLayoutY(13.0);
        balanceLabel.setPrefHeight(27.0);
        balanceLabel.setPrefWidth(81.0);
        balanceLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        balanceLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 18.0));

        Label currencyLabel = new Label("PKR");
        currencyLabel.setLayoutX(14.0);
        currencyLabel.setLayoutY(47.0);
        currencyLabel.setPrefHeight(20.0);
        currencyLabel.setPrefWidth(37.0);
        currencyLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        currencyLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 14.0));

        Label balanceAmountLabel = new Label("1000");
        balanceAmountLabel.setLayoutX(48.0);
        balanceAmountLabel.setLayoutY(47.0);
        balanceAmountLabel.setPrefHeight(20.0);
        balanceAmountLabel.setPrefWidth(250.0);
        balanceAmountLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        balanceAmountLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));

        Button transferButton = new Button("Transfer");
        transferButton.setLayoutX(628.0);
        transferButton.setLayoutY(13.0);
        transferButton.setMnemonicParsing(false);
        transferButton.setPrefHeight(35.0);
        transferButton.setPrefWidth(144.0);
        transferButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #343e7c; -fx-border-radius: 10px;");
        transferButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

        Button topUpButton = new Button("Top Up");
        topUpButton.setLayoutX(628.0);
        topUpButton.setLayoutY(56.0);
        topUpButton.setMnemonicParsing(false);
        topUpButton.setPrefHeight(35.0);
        topUpButton.setPrefWidth(144.0);
        topUpButton.setStyle("-fx-background-color: WHITE; -fx-border-width: 1px; -fx-border-color: #ed7d29; -fx-border-radius: 10px;");
        topUpButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));

        Pane transactionsPane = new Pane();
        transactionsPane.setLayoutX(17.0);
        transactionsPane.setLayoutY(209.0);
        transactionsPane.setPrefHeight(50.0);
        transactionsPane.setPrefWidth(786.0);
        transactionsPane.setStyle("-fx-border-color: #343e7c; -fx-background-color: white; -fx-border-radius: 10px;");
        AnchorPane.setLeftAnchor(transactionsPane, 17.0);
        AnchorPane.setRightAnchor(transactionsPane, 17.0);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(45.0);
        imageView.setFitWidth(45.0);
        imageView.setLayoutX(9.0);
        imageView.setLayoutY(3.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        Label eventNameLabel = new Label("Event Name");
        eventNameLabel.setLayoutX(65.0);
        eventNameLabel.setLayoutY(16.0);
        eventNameLabel.setPrefHeight(20.0);
        eventNameLabel.setPrefWidth(177.0);
        eventNameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        eventNameLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 14.0));

        Label transactionAmountLabel = new Label("-1000 PKR");
        transactionAmountLabel.setLayoutX(645.0);
        transactionAmountLabel.setLayoutY(8.0);
        transactionAmountLabel.setPrefHeight(35.0);
        transactionAmountLabel.setPrefWidth(157.0);
        transactionAmountLabel.setTextAlignment(TextAlignment.RIGHT);
        transactionAmountLabel.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        transactionAmountLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 18.0));

        anchorPane.getChildren().addAll(
                walletLabel,
                viewAllButton,
                balancePane,
                transactionsPane
        );

        balancePane.getChildren().addAll(
                balanceLabel,
                currencyLabel,
                balanceAmountLabel,
                transferButton,
                topUpButton
        );

        transactionsPane.getChildren().addAll(
                imageView,
                eventNameLabel,
                transactionAmountLabel
        );
        primaryStage.setCenter(anchorPane);
    }

}