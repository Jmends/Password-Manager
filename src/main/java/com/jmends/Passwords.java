package com.jmends;

import java.util.Random;

public class Passwords {
    private int id;
    private int user_id;
    private String website;
    private String username;
    private String password;
//
//    public Passwords(int id, int user_id, String website, String username, String password) {
//        this.id = id;
//        this.user_id = user_id;
//        this.website = website;
//        this.username = username;
//        this.password = password;
//    }
//
//    public Passwords() {
//
//    }

    public String generatePassword() {
        Random random = new Random();
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"};

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
                "-", "_", "=", "+", "[", "]", "{", "}", ";", ":",
                "'", "\"", "<", ">", ",", ".", "/", "?"};

        String[] allCharacters = new String[letters.length + numbers.length + symbols.length];
        int index = 0;


        for (String letter : letters) {
            allCharacters[index++] = letter;
        }
        for (String number : numbers) {
            allCharacters[index++] = number;
        }
        for (String symbol : symbols) {
            allCharacters[index++] = symbol;
        }

        int passwordLength = 6 + random.nextInt(7);

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            password.append(allCharacters[random.nextInt(allCharacters.length)]);
        }

        return password.toString();

    }
}
