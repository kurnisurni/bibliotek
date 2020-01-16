package com.company;

import java.util.ArrayList;

public class Member {
    private String name;
ArrayList<Book>borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public void addLoan(Book book){
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void showLoans() {
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
