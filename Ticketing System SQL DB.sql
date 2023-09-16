CREATE DATABASE sdaProject;
USE sdaProject;

DROP TABLE IF EXISTS Reservation;
DROP TABLE IF EXISTS Campaigns;
DROP TABLE IF EXISTS Coupons;
DROP TABLE IF EXISTS Events;
DROP TABLE IF EXISTS UserAccount;
DROP TABLE IF EXISTS Messages;
DROP TABLE IF EXISTS SupportTable;
DROP TABLE IF EXISTS User;


CREATE TABLE User(
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	username VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(255) CHECK (role IN ('Customer', 'Admin', 'Event Organizer', 'Support Team')),
	dob DATE,
	email VARCHAR(255),
	gender VARCHAR(255) CHECK (gender IN ('Male', 'Female', 'Other')),
	tAndC BOOLEAN,
	isActive BOOLEAN
);

CREATE TABLE UserAccount (
    id INT AUTO_INCREMENT PRIMARY KEY,
    security_question VARCHAR(255),
    answer VARCHAR(255),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE events (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  date DATE,
  time TIME,
  location VARCHAR(255),
  description TEXT,
  picture VARCHAR(255),
  numberOfTickets INT,
  price INT,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Reservation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    user_id INT,
    name VARCHAR(255),
    cnic VARCHAR(255),
    contact VARCHAR(255),
    quantity INT,
    cardNumber VARCHAR(255),
    nameOnCard VARCHAR(255),
    CVV VARCHAR(255),
    doe date,
    type VARCHAR(255),
    FOREIGN KEY (event_id) REFERENCES Events(id),
    FOREIGN KEY (user_id) REFERENCES User(id)
);


CREATE TABLE coupons (
    id INT PRIMARY KEY auto_increment,
    description VARCHAR(255),
    start_date DATE,
    end_date DATE,
    event_id INT,
    code varchar(255),
    discount DOUBLE,
    min_price DOUBLE,
    max_price DOUBLE,
    available_coupons INT
);

CREATE TABLE campaigns (
    id INT PRIMARY KEY auto_increment,
    picture VARCHAR(255),
    description VARCHAR(255),
    start_date DATE,
    end_date DATE,
    event_id INT,
    plan VARCHAR(255),
    coupon_id INT,
    FOREIGN KEY (event_id) REFERENCES events(id)
);


CREATE TABLE SupportTable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question TEXT,
    questionTopic VARCHAR(255),
    dateTime DATE,
    customerId INT,
    supportPersonId INT,
    CONSTRAINT FK_Customer FOREIGN KEY (customerId) REFERENCES User(id),
    CONSTRAINT FK_SupportPerson FOREIGN KEY (supportPersonId) REFERENCES User(id)
);

CREATE TABLE Messages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    message TEXT,
    dateTime DATE,
    userId INT,
    SupportTableId INT,
    CONSTRAINT FK_User FOREIGN KEY (userId) REFERENCES User(id),
    CONSTRAINT FK_SupportTable FOREIGN KEY (SupportTableId) REFERENCES SupportTable(id)
);


INSERT INTO USER (first_name, last_name, username, password, role, dob, email, gender, tAndC, isActive)
VALUES
  ('Basit', 'Nazir', 'support', 'support', 'Support Team', '2003-07-04', 'basitnazir03@yahoo.com', 'Male', true, true),
  ('Basit', 'Nazir', 'atif', '123', 'Event Organizer', '2003-07-04', 'basitnazir03@yahoo.com', 'Male', true, true),
  ('Basit', 'Nazir', 'admin', 'admin', 'Admin', '2003-07-04', 'basitnazir03@yahoo.com', 'Male', true, true),
  ('Basit', 'Nazir', 'basit', '123', 'Customer', '2003-07-04', 'basitnazir03@yahoo.com', 'Male', true, true);


INSERT INTO UserAccount(id, security_question, answer, user_id) VALUES(1,'Who are you?', 'Basit', 1);


INSERT INTO events (name, date, time, location, description, picture, numberOfTickets, price)
VALUES
  ('Event 1', '2023-06-01', '10:00:00', 'Location 1', 'Description 1', 'picture1.jpg', 100, 10),
  ('Event 2', '2023-06-02', '15:30:00', 'Location 2', 'Description 2', 'picture2.jpg', 150, 20),
  ('Event 3', '2023-06-03', '18:00:00', 'Location 3', 'Description 3', 'picture3.jpg', 200, 15),
  ('Event 4', '2023-06-04', '12:30:00', 'Location 4', 'Description 4', 'picture4.jpg', 50, 25),
  ('Event 5', '2023-06-05', '20:00:00', 'Location 5', 'Description 5', 'picture5.jpg', 80, 12);
