package com.company;

import java.util.ArrayList;

public class Librarian extends User {

    public Librarian(String userName, int id, String password, String userType) {
        super(userName, id, password, userType);
    }
}
    /*
    //Show all members
    public void showMembers(){
        for (Member member: members){
            System.out.println(member);
        }
    }

    //Find a certain member of the library. If not found, return null.
    private Member findMember(String name){
        for (Member member : members){
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    //Show all the loans of a certain member
    public void showMemberLoans(String memberName) {
        Member member = findMember(memberName);
        if (member != null) {
            member.showLoan();
        }
    }

    public void showAllMemberLoans(){
        //loop through all members...
        for (Member member: members){
            showMemberLoans(member.getName()); //and show all loans for each member...
        }
    }

    //A method to add new book to the library
    public void addBookToLibrary(Book newBook){
        books.add( newBook );
    }

    //Add members to the library
    public void addMember(String name){
        members.add( new Member(name));
    }

    public void showBorrowedBooks(){
        for (Book book : books){
            if (!book.getAvailable()){
                System.out.println(book);
            }
        }
    }

    public void showAvailableBooks(){
        for (Book book : books){
            if (book.getAvailable()){
                System.out.println(book);
            }
        }
    }

    public void removeBookFromLibrary(Book removedBook){
        books.remove(removedBook);
    }*/


