package com.library.dao;

import com.library.models.Book;
import com.library.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public  void addBook(Book book){
        String query = "INSERT INTO books(title,author,quantity) VALUES(?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getQuantity());
            ps.executeUpdate();
            System.out.println("✅ Book added successfully!");
        }catch (SQLException e){
            System.out.println("❌ Error Adding Book: "+e.getMessage());
        }
    }
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try(Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println("❌ Error fetching books: "+e.getMessage());
        }
        return books;
    }
    public int updateBook(Book book){
        String query = "UPDATE books SET title=?,author=?,quantity=? WHERE id=?";
        try(Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getQuantity());
            ps.setInt(4,book.getId());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("❌Error Updating Book: "+e.getMessage());
        }
        return 0;
    }

    public Book getBookById(int id){
        String query = "SELECT * FROM books WHERE id=?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                return book;
            }else{
                return null;
            }

        }catch (SQLException e){
            System.out.println("❌ Error Fetching Book: "+e.getMessage());
        }
        return null;
    }

    public void deleteBook(int id){
        String query="DELETE FROM books WHERE id=?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1,id);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("✅ Book deleted successfully!");
            }else{
                System.out.println("⚠️ Book not food");
            }
        }catch(SQLException e){
            System.out.println("❌ Error deleting book: "+e.getMessage());
        }
    }
}
