package com.jmends;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Users {
    private int id;
    private String username;


    public Users(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public Users() {
        //for unit testing
    }

    public int getId() {
        return id;
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public void createAccount(String username, String password) {
        try (Connection conn = DatabaseHandler.getConnection()) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}


