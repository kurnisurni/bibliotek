package com.company;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();


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


    //Show all books
    public void showBooks() {
        for (Book book : books){
            if ( book instanceof Book){
                System.out.println(book);
            }
        }
    }


}
