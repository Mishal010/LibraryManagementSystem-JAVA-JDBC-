package com.library.services;

import java.util.Scanner;

public class AdminService {
    private final Scanner scanner = new Scanner(System.in);
    public void menu(){
        while(true){
            System.out.println("\n👨‍💻 Admin Menu:");
            System.out.println("1. Manage Users");
            System.out.println("2. View Reports");
            System.out.println("3. Logout");

            System.out.print("Enter choice: ");
            int choice=Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 -> System.out.println("Managing users...");
                case 2 -> System.out.println("Viewing reports...");
                case 3 -> {
                    System.out.println("👋Logging out...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}
