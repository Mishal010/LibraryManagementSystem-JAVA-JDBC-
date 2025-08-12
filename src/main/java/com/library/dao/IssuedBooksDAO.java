package com.library.dao;

import java.sql.Connection;

public class IssuedBooksDAO {
    private Connection conn;
    public IssuedBooksDAO(Connection conn){
        this.conn = conn;
    }
}
