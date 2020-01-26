package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends User {

   public Librarian(String userName, String password) {
            super(userName, password);
        }

    public void librarian(ArrayList<User> members, ArrayList<Book> libraryBooks) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\"Hi, librarian! \\n Please, select the menu:\\n\"");
            System.out.println("1. Add new book");
            System.out.println("2. Remove book");
            System.out.println("3. See all books");
            System.out.println("4. See borrowed books");
            System.out.println("0. Save & Exit");
            String librarianChoice = scanner.nextLine();
            switch (librarianChoice) {
                case "1":
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter Summary: ");
                    String summary = scanner.nextLine();
                    addBookToLibrary(libraryBooks, title, author, summary);
                    break;
                case "2":
                    printAllLibraryBooks(libraryBooks);
                    System.out.println("Enter Title: ");
                    String bookToRemoveTitle = scanner.nextLine();
                    removeBookFromLibrary(bookToRemoveTitle, libraryBooks);
                    break;
                case "3":
                        printAllLibraryBooks(libraryBooks);
                    break;
                case "4":
                    seeBorrowedBooks(libraryBooks);
                    break;
                case "0":
                    System.out.println("You are successfully exit the system!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Incorrect input. Try again.");
                    break;
            }
        }
    }

    void printAllLibraryBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
            System.out.println(book.getDescription());
            System.out.println("------------------------------------------");
        }
    }

    void removeBookFromLibrary(String title, ArrayList<Book> libraryBooks) {
        Book book = findBookByTitleAuthor(title, libraryBooks);
        libraryBooks.remove(book);
        System.out.println(book.getTitle() + " is removed.");
    }

    void addBookToLibrary(ArrayList<Book> books, String title, String author, String description) {
        books.add(new Book(title, author, description));
        System.out.println(title + " added to library collection");
    }

    private void seeBorrowedBooks(ArrayList<Book> books) {
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book);
            } else {
                System.out.println("No books has been borrowed.");
                break;
            }
        }
    }
}

