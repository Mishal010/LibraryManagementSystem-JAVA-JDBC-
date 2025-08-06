package com.library;

import com.library.auth.AuthService;
import com.library.auth.RoleRouter;
import com.library.models.User;
import com.library.util.DBConnection;

public class Main {
    public static void main(String[] args) {
//        DBConnection.testConnection();
        AuthService authService = new AuthService();
        User user = authService.login();
        if(user != null){
            new RoleRouter().route(user);
        }else {
            System.out.println("Something went wrong");
        }
    }
}
