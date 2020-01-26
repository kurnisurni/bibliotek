package com.company;

import java.util.ArrayList;

public class Member extends User {
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String userName, String password) {
        super(userName, password);
    }


    public void addLoan(Book book){
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + getUserName() + '\'' +
                '}';
    }

    public String getName() {
        return getUserName();
    }

    public void showLoan() {
        //If no loans... don't display anything...
        if (borrowedBooks.size()==0)
            return;

        System.out.println(getName()+"'s loans:\n-----------");
        for (Book book : borrowedBooks){
            System.out.println(book);
        }
        System.out.println("--------------");
    }

    public void returnLoan(String title) {
        for (Book book : borrowedBooks){
            if (book.getTitle().equals(title)){
                borrowedBooks.remove(book);
                book.setAvailable(true);
                return;
            }
        }
    }

    public void memberBorrowBook(Book book) {
            if (book != null && book.isAvailable()) {
                borrowedBooks.add(book);
                book.setAvailable(false);
                System.out.println(getName() + " borrows a book with title " + book.getTitle());
            } else {
                System.out.println("Error! " + getName()+ " could not borrow " + book.getTitle());
            }
    }

    public void memberReturnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
        System.out.println(book.getTitle() + " returned to library");
    }


}

