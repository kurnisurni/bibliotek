package com.company;

import java.util.ArrayList;

public class Member extends User {
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String userName, int id, String password, String userType, ArrayList<Book> borrowedBooks) {
        super(userName, id, password, userType);
        this.borrowedBooks = borrowedBooks;
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
}

