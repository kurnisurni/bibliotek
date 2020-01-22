package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryProgram {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private Librarian currentLibrarian;
    private transient Scanner scanner = new Scanner(System.in);


    public void start() {
renderBookListFromFile();
renderMembersFromFile();

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
                    librarian();
                    break;
                case "0":
                    System.out.println("Goodbye!");
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
            System.out.println("0. Save and exit");


            String memberChoice = scanner.next();
            switch (memberChoice) {
                case "1":
                    showAllBooks(books);
                    break;
                case "2":
                    showAvailableBooks();
                    break;
                case "3":
                    //bookInformation();
                    break;
                case "4":
                    searchForBook();
                    break;
                case "5":
                    borrowBook();
                    break;
                case "6":
                    showMyBookAccount();
                    break;
                case "7":
                    returnBook();
                    break;
                case "0":
                    FileUtility.writeObject(this, "saveAccount.ser");
                    System.out.println("Thanks and hope to see you again!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 7");
            }
        }
    }

private void showAllBooks(ArrayList<Book> books){
for(Book book:books){
    System.out.println(book);
}
}

private void showAvailableBooks(){
for(Book book: books){
if(book.isAvailable()){
    System.out.println(book);
}
}
}

private Book findBookByTitleAuthor(String title, String author){
for(Book book:books){
    if(book==null){
        continue;
    }
    if(book.getTitle().equals(title) || book.getAuthor().equals(author)){
        return book;
    }
}
    System.out.println("Book is not found.");
   return null;
}

private void searchForBook(){
Scanner scanner = new Scanner(System.in);
    System.out.println("Please, enter a book title or author:");
    String bookTitle = scanner.nextLine();
    String bookAuthor = scanner.nextLine();
Book book = findBookByTitleAuthor(bookTitle, bookAuthor);
    if (book == null){
        System.out.println("Sorry, " + bookTitle + "is not found.");
    } else{
        System.out.println(book);
    }
}

public void borrowBook(String userName, String title){
    Member member = Member(userName);
    //Check if we find member with this name...
    if (member != null) {
        for (Book book : books) {
            if ( book.getTitle().equals(title) &&
                    book.isAvailable()){
                member.addLoan(book);
                System.out.println(member.getName()+" borrowed the item with title "+book.getTitle());
                return; //we're done... return!
            }
        }
    }
    //Something went wrong...
    System.out.println(member.getName()+" could not borrow "+title);
}

public void showMyBookAccount(){
//If no loans... don't display anything...
    if (borrowedBooks.size()==0)
        return;
    for (Book book : borrowedBooks){
        System.out.println(book);
    }
    System.out.println("--------------");
}

public void returnBook(){
    for (Book book : borrowedBooks){
        if (book.getTitle().equals(title)){
            borrowedBooks.remove(book);
            book.setAvailable(true);
            return;
        }
    }
}

    private void librarian() {
        boolean running = true;

        while (running) {
            System.out.println("Hi, librarian! \n Please, select the menu:\n");
            System.out.println("1. Search a member");
            System.out.println("2. Add a member");
            System.out.println("3. See borrowed books");
            System.out.println("4. Remove a book");
            System.out.println("5. Add a new book");
            System.out.println("0. Exit");

        }


        String librarianChoice = scanner.next();
        switch (librarianChoice) {
            case "1":
                findMember(null);
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
                break;
            default:
                System.out.println("Wrong input. Please, enter a number between 0 to 7");
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

    //Add members to the library
    public void addMember(String userName){
        members.add( new Member());
    }

    //Show all the loans of a certain member
    public void showMemberLoans(String memberName) {
        Member member = findMember(memberName);
        if (member != null) {
            member.showLoan();
        }
    }

    public void seeBorrowedBooks(){
        //loop through all members...
        for (Member member: members){
            showMemberLoans(member.getName()); //and show all loans for each member...
        }
    }

    public void addNewBook(Book newBook){
        books.add( newBook );
    }

    private void removeBook(String title, ArrayList<Book> books) {
        Book book = findBookByTitleOrAuthor(title, books);
        books.remove(book);
        System.out.println(book.getTitle() + " is removed.");
    }

public void renderBookListFromFile(){
books =(ArrayList<Book>)FileUtility.loadObject("bookList.ser");
}

public void renderMembersFromFile(){
members =(ArrayList<Member>)FileUtility.loadObject("members.ser");
}
}




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






