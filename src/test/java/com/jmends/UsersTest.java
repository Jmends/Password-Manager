package com.jmends;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void hashPasswordTest() throws NoSuchAlgorithmException {
        Users user = new Users();

        String plainPassword = "password123";
        String hashedPassword = Users.hashPassword(plainPassword);
        //checks if hashed password is not null
        assertNotNull(hashedPassword,"Password should not be null");

        //checks if plain password and hashed password are equal
        assertNotEquals(plainPassword,hashedPassword,"plain text password and hashed password should not be equal");

        //checks for consistent hashing of password
        String sameHash = Users.hashPassword(plainPassword);
        assertEquals(hashedPassword,sameHash,"both hashed passwords should be equal");


    }
}