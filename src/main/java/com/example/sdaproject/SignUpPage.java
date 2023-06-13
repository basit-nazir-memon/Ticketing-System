package com.example.sdaproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.sql.Date;

public class SignUpPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        File file = new File("src/images/logo.png");
        Image image = new Image(file.toURI().toString());

        file = new File("src/images/backgroundImg.jpg");
        Image back = new Image(file.toURI().toString());

        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 600);
        root.setStyle("-fx-background-color: white;");

        ImageView imageView = new ImageView();
        imageView.setFitWidth(1000);
        imageView.setFitHeight(600);
        imageView.setImage(back);
        imageView.setPreserveRatio(false);
        imageView.setPickOnBounds(true);

        ImageView logoImageView = new ImageView();
        logoImageView.setFitHeight(69.0);
        logoImageView.setFitWidth(100.0);
        logoImageView.setLayoutX(14.0);
        logoImageView.setLayoutY(14.0);
        logoImageView.setImage(image);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);

        Pane pane = new Pane();
        pane.setLayoutX(195);
        pane.setLayoutY(14);
        pane.setPrefSize(609, 572);
        pane.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-width: 5px; -fx-border-radius: 5px; -fx-background-radius: 10px; ");

        Label firstNameLabel = new Label("First Name");
        firstNameLabel.setLayoutX(14);
        firstNameLabel.setLayoutY(102);
        firstNameLabel.setPrefSize(98, 20);
        firstNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        firstNameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        firstNameLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 14));

        Label lastNameLabel = new Label("Last Name");
        lastNameLabel.setLayoutX(344);
        lastNameLabel.setLayoutY(103);
        lastNameLabel.setPrefSize(98, 20);
        lastNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lastNameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        lastNameLabel.setFont(Font.font("System Bold",FontWeight.BOLD, 14));

        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(17);
        usernameLabel.setLayoutY(138);
        usernameLabel.setPrefSize(98, 20);
        usernameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        usernameLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        usernameLabel.setFont(Font.font("System Bold", FontWeight.BOLD, 14));

        Label emailLabel = new Label("Email");
        emailLabel.setLayoutX(17);
        emailLabel.setLayoutY(249);
        emailLabel.setPrefSize(98, 20);
        emailLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        emailLabel.setFont(Font.font("System Bold",FontWeight.BOLD, 14));

        Label passwordLabel = new Label("Password");
        passwordLabel.setLayoutX(17);
        passwordLabel.setLayoutY(175);
        passwordLabel.setPrefSize(98, 20);
        passwordLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        passwordLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        passwordLabel.setFont(Font.font("System Bold",FontWeight.BOLD, 14));

        TextField firstNameTextField = new TextField();
        firstNameTextField.setLayoutX(167);
        firstNameTextField.setLayoutY(99);
        firstNameTextField.setPrefSize(150, 27);
        firstNameTextField.setPromptText("First Name");
        firstNameTextField.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        TextField lastNameTextField = new TextField();
        lastNameTextField.setLayoutX(440);
        lastNameTextField.setLayoutY(99);
        lastNameTextField.setPrefSize(150, 27);
        lastNameTextField.setPromptText("Last Name");
        lastNameTextField.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(167);
        usernameTextField.setLayoutY(134);
        usernameTextField.setPrefSize(302, 27);
        usernameTextField.setPromptText("Username");
        usernameTextField.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        TextField emailTextField = new TextField();
        emailTextField.setLayoutX(167);
        emailTextField.setLayoutY(244);
        emailTextField.setPrefSize(302, 27);
        emailTextField.setPromptText("Email");
        emailTextField.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        TextField passwordTextField = new TextField();
        passwordTextField.setLayoutX(167);
        passwordTextField.setLayoutY(171);
        passwordTextField.setPrefSize(302, 27);
        passwordTextField.setPromptText("Password");
        passwordTextField.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        Label confirmPasswordLabel = new Label("Confirm Password");
        confirmPasswordLabel.setLayoutX(16);
        confirmPasswordLabel.setLayoutY(211);
        confirmPasswordLabel.setPrefSize(123, 20);
        confirmPasswordLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        confirmPasswordLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        confirmPasswordLabel.setFont(Font.font("System Bold",FontWeight.BOLD, 14));

        TextField confirmPasswordTextField = new TextField();
        confirmPasswordTextField.setLayoutX(167);
        confirmPasswordTextField.setLayoutY(207);
        confirmPasswordTextField.setPrefSize(302, 27);
        confirmPasswordTextField.setPromptText("Re-Enter Password");
        confirmPasswordTextField.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        Label signUpLabel = new Label("Sign Up");
        signUpLabel.setLayoutX(267);
        signUpLabel.setLayoutY(29);
        signUpLabel.setTextFill(javafx.scene.paint.Color.web("#363e7c"));
        signUpLabel.setFont(Font.font("System Bold Italic",FontWeight.BOLD, FontPosture.ITALIC, 28));

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(12);
        loginButton.setLayoutY(11);
        loginButton.setPrefSize(98, 11);
        loginButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        loginButton.setTextFill(javafx.scene.paint.Color.web("#ed7d29"));
        loginButton.setFont(Font.font(13));
        loginButton.setOnMouseClicked(e->{
            Login l = new Login();
            try {
                l.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Label dobLabel = new Label("DOB");
        dobLabel.setLayoutX(17);
        dobLabel.setLayoutY(285);
        dobLabel.setPrefSize(98, 20);
        dobLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        dobLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        dobLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14));

        Label genderLabel = new Label("Gender");
        genderLabel.setLayoutX(17);
        genderLabel.setLayoutY(318);
        genderLabel.setPrefSize(98, 20);
        genderLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        genderLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        genderLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14));

        Label roleLabel = new Label("Role");
        roleLabel.setLayoutX(384);
        roleLabel.setLayoutY(319);
        roleLabel.setPrefSize(34, 20);
        roleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        roleLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        roleLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14));

        Label securityQuestionLabel = new Label("Security Question");
        securityQuestionLabel.setLayoutX(17);
        securityQuestionLabel.setLayoutY(349);
        securityQuestionLabel.setPrefSize(134, 20);
        securityQuestionLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        securityQuestionLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        securityQuestionLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14));

        Label answerLabel = new Label("Answer");
        answerLabel.setLayoutX(17);
        answerLabel.setLayoutY(430);
        answerLabel.setPrefSize(134, 20);
        answerLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        answerLabel.setTextFill(javafx.scene.paint.Color.web("#343e7c"));
        answerLabel.setFont(Font.font("System Bold", FontWeight.BOLD,14));

        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.setLayoutX(438);
        roleComboBox.setLayoutY(315);
        roleComboBox.setPrefSize(150, 27);
        roleComboBox.setStyle("-fx-background-color: white; -fx-border-color: #343e7c; -fx-border-radius: 5px;");
        roleComboBox.getItems().addAll("Customer", "Event Organizer");

        TextArea securityQuestionTextArea = new TextArea();
        securityQuestionTextArea.setLayoutX(168);
        securityQuestionTextArea.setLayoutY(349);
        securityQuestionTextArea.setPrefSize(423, 73);
        securityQuestionTextArea.setPromptText("e.x. What is your middle name?");
        securityQuestionTextArea.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setLayoutX(172);
        maleRadioButton.setLayoutY(320);
        maleRadioButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

        DatePicker dobDatePicker = new DatePicker();
        dobDatePicker.setLayoutX(167);
        dobDatePicker.setLayoutY(281);
        dobDatePicker.setPrefSize(302, 27);
        dobDatePicker.setStyle("-fx-background-color: WHITE; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setLayoutX(226);
        femaleRadioButton.setLayoutY(320);
        femaleRadioButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

        RadioButton otherRadioButton = new RadioButton("Other");
        otherRadioButton.setLayoutX(292);
        otherRadioButton.setLayoutY(320);
        otherRadioButton.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

        femaleRadioButton.setOnAction(e->{
            maleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);
        });

        maleRadioButton.setOnAction(e->{
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);
        });

        otherRadioButton.setOnAction(e->{
            femaleRadioButton.setSelected(false);
            maleRadioButton.setSelected(false);
        });



        TextArea answerTextArea = new TextArea();
        answerTextArea.setLayoutX(168);
        answerTextArea.setLayoutY(430);
        answerTextArea.setPrefSize(423, 56);
        answerTextArea.setPromptText("e.x. Abraham");
        answerTextArea.setStyle("-fx-background-color: White; -fx-border-color: #343e7c; -fx-border-radius: 5px;");

        CheckBox termsCheckBox = new CheckBox("I Agree to terms & Conditions");
        termsCheckBox.setLayoutX(16);
        termsCheckBox.setLayoutY(496);
        termsCheckBox.setTextFill(javafx.scene.paint.Color.web("#343e7c"));

        Label errorLabel = new Label("Error");
        errorLabel.setLayoutX(250);
        errorLabel.setLayoutY(496);
        errorLabel.setTextFill(Paint.valueOf("RED"));
        errorLabel.setVisible(false);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setLayoutX(111);
        signUpButton.setLayoutY(520);
        signUpButton.setPrefSize(387, 40);
        signUpButton.setStyle("-fx-background-color: WHITE; -fx-border-color: #ed7d29; -fx-background-color: #ed7d29; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        signUpButton.setTextFill(javafx.scene.paint.Color.WHITE);
        signUpButton.setFont(Font.font("System Bold", FontWeight.BOLD,14));
        signUpButton.setOnAction(e->{
            errorLabel.setVisible(true);
            String gender = (maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female": "Other");
            String response = SingletonTicketingSystemController.getInstance().registerUser(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), usernameTextField.getText(),
                                                                            passwordTextField.getText(), confirmPasswordTextField.getText(),gender, securityQuestionTextArea.getText(),
                                                                            answerTextArea.getText(), dobDatePicker.getValue() == null ? null : Date.valueOf(dobDatePicker.getValue()), termsCheckBox.isSelected(), roleComboBox.getValue());
            errorLabel.setText(response);
            if (response.equals("Created")){
                signUpButton.setVisible(false);
                loginButton.setPrefSize(387,40);
                loginButton.setLayoutX(111);
                loginButton.setLayoutY(520);
                signUpButton.setFont(Font.font("System Bold", FontWeight.BOLD,14));
                errorLabel.setText("User Created Successfully");
                errorLabel.setTextFill(Paint.valueOf("GREEN"));
            }
        });

        pane.getChildren().addAll(
                firstNameLabel,
                lastNameLabel,
                usernameLabel,
                emailLabel,
                passwordLabel,
                firstNameTextField,
                lastNameTextField,
                usernameTextField,
                emailTextField,
                passwordTextField,
                confirmPasswordLabel,
                confirmPasswordTextField,
                signUpLabel,
                loginButton,
                dobLabel,
                genderLabel,
                roleLabel,
                securityQuestionLabel,
                answerLabel,
                roleComboBox,
                securityQuestionTextArea,
                maleRadioButton,
                dobDatePicker,
                femaleRadioButton,
                otherRadioButton,
                answerTextArea,
                termsCheckBox,
                signUpButton,
                errorLabel
        );

        root.getChildren().addAll(imageView, logoImageView, pane);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

