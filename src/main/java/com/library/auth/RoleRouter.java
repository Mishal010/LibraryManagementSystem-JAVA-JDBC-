package com.library.auth;

import com.library.models.User;
import com.library.services.AdminService;
import com.library.services.LibrarianService;
import com.library.services.MemberService;

public class RoleRouter {
    public void route(User user){
        switch(user.getRole().toUpperCase()){
            case "ADMIN":
                new AdminService().menu();
                break;
            case "LIBRARIAN":
                new LibrarianService().menu();
                break;
            case "MEMBER":
                new MemberService().menu();
                break;
            default:
                System.out.println("❌ Unknown role.");
        }
    }

}

