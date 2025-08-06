package com.library.auth;

import com.library.dao.UserDAO;
import com.library.models.User;

import java.util.Scanner;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();
    private final Scanner scanner = new Scanner(System.in);

    public User login(){
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        User user = userDAO.getUserByUsername(username);
        if(user!=null && user.getPassword().equals(password)){
            System.out.println("✅ Login successful. Welcome, "+user.getUsername());
            return user;
        }else{
            System.out.println("❌ Invalid credentials.");
            return null;
        }
    }
}
