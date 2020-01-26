package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User {
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String userName, String password) {
        super(userName, password);
    }

    public Book myAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. See my loaned books");
        System.out.println("2. Return a book");
        String memberChoice = scanner.nextLine();
        switch (memberChoice) {
            case "1":
                showBorrowedBooks();
                break;
            case "2":
                try {
                    showBorrowedBooks();
                    if (borrowedBooks.isEmpty()) {
                        break;
                    } else {
                        System.out.println("Enter title of the book you wish to return: ");
                        String bookTitle = scanner.nextLine();
                        returnBookToLibrary(findBookByTitleAuthor(bookTitle, borrowedBooks));
                    }
                } catch (Exception e){
                    System.out.println("This book is not here!");
                }
                break;
            default:
                System.out.println("Wrong input. Please, enter 1 or 2");
                break;
        }
        return null;
    }

    private void returnBookToLibrary(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
        System.out.println(book.getTitle() + " returned to library");
    }

    public void showBorrowedBooks() {
        if (!borrowedBooks.isEmpty()) {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("You haven't borrowed a book yet!");
        }
    }

    public void memberBorrowBook(Book book) {
        if (book != null && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(getUserName() + " borrows a book with title " + book.getTitle());
        } else {
            System.out.println("Error! " + getUserName()+ " could not borrow " + book.getTitle());
        }
    }

    Book findBookByTitleAuthor(String title, ArrayList<Book> books){
        for(Book book:books){
            if(book==null){
                continue;
            }
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()) || book.getAuthor().toLowerCase().contains(title.toLowerCase())){
                return book;
            }
        }
        System.out.println("Book is not found.");
        return myAccount();
    }
}


