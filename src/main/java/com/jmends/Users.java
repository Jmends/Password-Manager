package com.jmends;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
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

    public String getUsername() {
        return username;
    }

    public static Users login(String username,String password)  {
        try(Connection conn = DatabaseHandler.getConnection()){
            String hashedPassword = hashPassword(password);
            String sql = "SELECT id, username FROM users WHERE username = ? AND password_hash = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,username);
            pstmt.setString(2,hashedPassword);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                return new Users(rs.getInt("id"),rs.getString("username"));
            }
        } catch (SQLException |NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }


    public static Boolean createAccount(String username, String password)  {
        String hashedPassword;
        try {
            hashedPassword = hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR HASHING PASSWORD: " + e.getMessage());
            return false;
        }
        String sql = "INSERT INTO users(username,password_hash) VALUES (?,?)";



        try(Connection conn = DatabaseHandler.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,username);
            pstmt.setString(2,hashedPassword);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            System.out.println("ERROR REGISTERING USER: " + e.getMessage());
            return false;
        }
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

}


