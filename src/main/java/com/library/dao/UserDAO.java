package com.library.dao;

import com.library.models.User;
import com.library.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserByUsername(String username){
        String query = "SELECT * FROM users WHERE username=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            }
        }catch(SQLException e){
            System.out.println("UserDAO Error: " + e.getMessage());
        }
        return null;
    }
}
