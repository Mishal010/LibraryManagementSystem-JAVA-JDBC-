package com.library.services;

import java.util.Scanner;

public class MemberService {
    private final Scanner scanner = new Scanner(System.in);
    public void menu(){
        while(true){
            System.out.println("\n👨🏻‍💼 Member Menu:");
            System.out.println("1. View Available Books");
            System.out.println("2. My Issued Books");
            System.out.println("3. Logout");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1-> System.out.println("📚 Showing available books...");
                case 2-> System.out.println("📗 Your issued books...");
                case 3->{
                    System.out.println("👋🏻 Logging out...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");

            }
        }
    }
}
