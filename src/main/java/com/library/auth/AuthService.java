package com.library.auth;

import com.library.dao.UserDAO;
import com.library.models.User;

import java.util.Scanner;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();
    private final Scanner scanner = new Scanner(System.in);

    public User login(){
        int attempt = 0;
        final int MAX_ATTEMPT =5;
        while(attempt<MAX_ATTEMPT){
            System.out.print("Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Password: ");
            String password = scanner.nextLine().trim();

            User user = userDAO.getUserByUsername(username);
            if(user!=null && user.getPassword().equals(password)){
                System.out.println("✅ Login successful. Welcome, "+user.getUsername());
                return user;
            }
                attempt++;
                System.out.println("❌ Invalid Credentials.Attempts left: "+(MAX_ATTEMPT-attempt));

        }
        System.out.println("🚫 Too many failed login attempts. Exiting...");
        return null;
    }
}
