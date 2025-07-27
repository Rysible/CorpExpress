package com.example.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtil {
    private static Connection myConnection = null;
    public static Connection getConnection() {
        if (myConnection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                myConnection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/CorporateExpressionsDatabase", "root", "root");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return myConnection;

    }



}
