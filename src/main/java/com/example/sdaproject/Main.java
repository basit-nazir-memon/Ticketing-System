package com.example.sdaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sdaProject";
    static final String USER = "root";
    static final String PASS = "123009111";
    private Connection conn = null;
    private Statement stmt = null;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query to create student table
            System.out.println("Creating student table...");
            stmt = conn.createStatement();
            String createStudentTable = "CREATE TABLE student " +
                    "(student_id INT NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " cgpa FLOAT, " +
                    " sgpa FLOAT, " +
                    " age INT, " +
                    " PRIMARY KEY ( student_id ))";
            stmt.executeUpdate(createStudentTable);

            // Insert 3 to 4 records in student table


            // Print all those students whose age is less
            // than 20 years
//            System.out.println("Printing students whose age is less than 20 years...");
//            String selectYoungStudents = "SELECT * FROM student WHERE age < 20";
//            ResultSet youngStudents = stmt.executeQuery(selectYoungStudents);
//            while (youngStudents.next()) {
//                int id = youngStudents.getInt("student_id");
//                String name = youngStudents.getString("name");
//                String email = youngStudents.getString("email");
//                float cgpa = youngStudents.getFloat("cgpa");
//                float sgpa = youngStudents.getFloat("sgpa");
//                int age = youngStudents.getInt("age");
//                System.out.println(id + ", " + name + ", " + email + ", " + cgpa + ", " + sgpa + ", " + age);
//            }

            // Close resources
//            youngStudents.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
