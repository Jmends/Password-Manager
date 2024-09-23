package com.jmends;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    DatabaseHandler.initializeDatabase();

    while(true){
        System.out.println("1. Register User\n2. Login\n3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // handles next line trap

        if (choice == 1){
            System.out.println("hi");
            break;
            // register user
        }
    }

    }
}