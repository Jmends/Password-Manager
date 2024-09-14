package com.jmends;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordsTest {

    @Test
    void shouldGeneratePassword() {
        Passwords password = new Passwords();

        String generatedPassword = password.generatePassword();

        assertFalse(generatedPassword.isEmpty(), "Password should not be empty");
    }
}