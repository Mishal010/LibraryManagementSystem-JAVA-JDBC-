package com.library.services;

import com.library.dao.BookDAO;
import com.library.models.Book;

import java.util.List;
import java.util.Scanner;

public class LibrarianService {
    private final Scanner scanner = new Scanner(System.in);
    private final BookDAO bookDAO = new BookDAO();
    public void menu(){
        while(true){
            System.out.println("\n🧔🏻‍♂️ Librarian Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");

            System.out.print("Enter choice: ");
            int choice =Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 -> addBook();
                case 2 -> System.out.println("📤 Issuing book...");
                case 3 -> System.out.println("📥 Returning book...");
                case 4 -> {
                    System.out.println("👋 Logging out...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
    private void addBook(){
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        bookDAO.addBook(new Book(title,author,quantity));
    }

    private void viewBooks(){
        List<Book> books = bookDAO.getAllBooks();
        if(books.isEmpty()){
            System.out.println("📭 No books available.");
        }else{
            System.out.println("\n 📚 Available Books:");
            books.forEach(book -> System.out.printf("ID: %d | Title: %s | Author: %s | Qty: %d%n"));
        }
    }
}
