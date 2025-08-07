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
            System.out.println("4. View Books");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Logout");


            System.out.print("Enter choice: ");
            int choice =Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 -> addBook();
                case 2 -> System.out.println("📤 Issuing book...");
                case 3 -> System.out.println("📥 Returning book...");
                case 4 -> viewBooks();
                case 5 -> updateBook();
                case 6 -> deleteBook();
                case 7 -> {
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
            books.forEach(book -> System.out.printf("ID: %d | Title: %s | Author: %s | Qty: %d%n",book.getId(),book.getTitle(),book.getAuthor(),book.getQuantity()));
        }
    }

    public void updateBook(){
        System.out.print("Enter book ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Book existingBook = bookDAO.getBookById(id);
        if(existingBook==null){
            System.out.println("❌ Book not found.");
            return;
        }
        System.out.println("Leave field empty and press Enter to keep existing value.");

        System.out.print("📖 New Title (current: " + existingBook.getTitle() + "): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.trim().isEmpty()) {
            existingBook.setTitle(newTitle);
        }

        System.out.print("✍️ New Author (current: " + existingBook.getAuthor() + "): ");
        String newAuthor = scanner.nextLine();
        if (!newAuthor.trim().isEmpty()) {
            existingBook.setAuthor(newAuthor);
        }

        System.out.print("📦 New Quantity (current: " + existingBook.getQuantity() + "): ");
        String newQtyInput = scanner.nextLine();
        if (!newQtyInput.trim().isEmpty()) {
            try {
                int newQty = Integer.parseInt(newQtyInput);
                existingBook.setQuantity(newQty);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid quantity. Keeping previous value.");
            }
        }

        int rowsUpdated = bookDAO.updateBook(existingBook);
        if (rowsUpdated > 0) {
            System.out.println("✅ Book updated successfully.");
        } else {
            System.out.println("❌ Update failed.");
        }
    }

    public void deleteBook(){
        System.out.print("Enter book ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        bookDAO.deleteBook(id);
    }

}
