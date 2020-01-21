package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryProgram {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private Librarian currentLibrarian;
    private transient Scanner scanner = new Scanner(System.in);


    public void start() {
        boolean running = true;
        System.out.println("Welcome to OOP-Java library");
        System.out.println("-----------------------------");

        while (running) {
            System.out.println("Please select the menu: ");
            System.out.println("1. Member");
            System.out.println("2. Librarian");
            System.out.println("3. Exit");

            String choice = scanner.next();
            switch (choice) {
                case "1":
                    member();
                    break;
                case "2":
                    //librarian();
                    break;
                case "0":
                    System.out.println("Hope to see you again!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 2");
            }
        }
    }

    private void member() {
        boolean running = true;

        while (running) {
            System.out.println("Hi, member! \n Please, select the menu:\n");
            System.out.println("1. See all the books");
            System.out.println("2. See all the available books");
            System.out.println("3. See a book's information");
            System.out.println("4. Search for a book");
            System.out.println("5. Borrow a book");
            System.out.println("6. My borrowed books account");
            System.out.println("7. Return a book");
            System.out.println("0. Exit");


String memberChoice = scanner.next();
switch (memberChoice){
    case "1":
        //showAllBooks();
        break;
    case "2":
        //showAvailableBooks();
        break;
    case "3":
        //bookInformation();
        break;
    case "4":
//searchForBook();
break;
    case "5":
        //borrowBook();
        break;
    case "6":
        //showMyBookAccount();
        break;
    case "7":
        //returnBook();
        break;
    case "0":
        System.out.println("Goodbye!");
        running = false;
        break;
    default:
        System.out.println("Wrong input. Please, enter a number between 0 to 7");
}
}
}
           /* private void librarian() {
                boolean isRunning = true;

                while (isRunning) {
                    System.out.println("Hi, librarian! \n Please, select the menu:\n");
                    System.out.println("1. Search a member");
                    System.out.println("2. Add a member");
                    System.out.println("3. See borrowed books");
                    System.out.println("4. Remove a book");
                    System.out.println("5. Add a new book");
                    System.out.println("0. Exit");
            }
            }*/



           /* String librarianChoice = scanner.next();
            switch (librarianChoice){
                case "1":
                    searchMember();
                    break;
                case "2":
                    addMember();
                    break;
                case "3":
                    seeBorrowedBooks();
                    break;
                case "4":
                    removeBook();
                    break;
                case "5":
                    addNewBook();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 7");
            }
        }
    }
*/

/*
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
    }*/


                }
            


