package com.company;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    //Find a certain member of the library. If not found, return null.
    private Member findMember(String name){
        for (Member member : members){
            if (member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }

    //Return a book with this title for this member...
    public void returnBook(String memberName, String title) {
        Member member = findMember(memberName);
        if (member != null) {
            member.returnLoan(title);
            System.out.println(member.getName()+" returned the item with title "+title);
        }
    }

    //Assuming that title is unique in all books list, this method will borrow any kind of book.
    public void borrowItem(
            String memberName,
            String title) {

        Member member = findMember(memberName);
        //Check if we find member with this name...
        if (member != null) {
            for (Book book : books) {
                if ( book.getTitle().equals(title) &&
                        book.getAvailable()
                ){
                    member.addLoan(book);
                    System.out.println(member.getName()+" borrowed the item with title "+book.getTitle());
                    return; //we're done... return!
                }
            }
        }
        //Something went wrong...
        System.out.println(member.getName()+" could not borrow "+title);
    }

    //A method to add new book to the library
    public void addBookToLibrary(Book newBook){
        books.add( newBook );
    }

    //Add members to the library
    public void addMember(String name){
        members.add( new Member(name));
    }

    //Show all members
    public void showMembers(){
        for (Member member: members){
            System.out.println(member);
        }
    }

    //Show all books
    public void showBooks() {
        for (Book book : books){
            if ( book instanceof Book){
                System.out.println(book);
            }
        }
    }


    //Show all the loans of a certain member
    public void showMemberLoans(String memberName) {
        Member member = findMember(memberName);
        if (member != null) {
            member.showLoan();
        }
    }

    public void showAvailableBooks(){
        for (Book book : books){
            if (book.getAvailable()){
                System.out.println(book);
            }
        }
    }


    public void showAllLibraryLoans(){
        //loop through all members...
        for (Member member: members){
            showMemberLoans(member.getName()); //and show all loans for each member...
        }
    }
}
