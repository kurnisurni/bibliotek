package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryProgram {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private Librarian currentLibrarian;
    private Member currentMember;
    private transient Scanner scanner = new Scanner(System.in);


    public void start() {
        getUsers();
//renderBookListFromFile();
//renderMembersFromFile();

        boolean running = true;
        System.out.println("Welcome to OOP-Java library");
        System.out.println("-----------------------------");

        while (running) {
            System.out.println("Please select the menu: ");
            System.out.println("1. Member");
            System.out.println("2. Librarian");
            System.out.println("3. Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    memberLogIn();
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

    private void memberLogIn(){
        System.out.println("Hi! Please, log in as a member to continue.. ");
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        for (User member : members) {
            if (username.equals(member.getUserName()) && password.equals(member.getPassword())) {
                 if (member instanceof Member) {
                    System.out.println("Welcome back, " + username + "!");
                    currentMember = (Member) member;
                    memberMenu();
                    break;
                }
            }
        }
        System.out.println("Password or username incorrect. Try again.");
    }

    private void memberMenu() {
        boolean running = true;

        while (running) {
            System.out.println("Please, select the menu:\n-----------------------------");
            System.out.println("1. See all the books");
            System.out.println("2. See all the available books");
            System.out.println("3. Search for a book");
            System.out.println("4. Borrow a book");
            System.out.println("5. My loaned books");
            System.out.println("6. Return a book");
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
                    System.out.println("Please, enter a book title or author");
                    searchForBook();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    myLoanedBooks();
                    break;
                case "6":
                    returnBook();
                    break;
                case "0":
                    FileUtility.writeObject(this, "saveAccount.ser");
                    System.out.println("Thanks and hope to see you again!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 6");
            }
        }
    }

private void showAllBooks(ArrayList<Book> books){
for(Book book:books){
    System.out.println(book);
    System.out.println(book.getDescription());
    System.out.println("---------------------------------------------------------------");
}
}

private void showAvailableBooks(){
for(Book book: books){
if(book.isAvailable()){
    System.out.println(book);
}
}
}

    private void searchForBook(){
            String searchedBook = scanner.nextLine();
        Book book = currentMember.findBookByTitleAuthor(searchedBook, books);
        if (book == null){
            System.out.println("Sorry, " + searchedBook + "is not found.");
        } else{
            System.out.println(book);
            System.out.println("Description: ");
            System.out.println(currentMember.findBookByTitleAuthor(searchedBook, books).getDescription());
        }
    }


public void borrowBook(){
    showAvailableBooks();
    System.out.println("Please, enter a book title or author:");
    String titleOrAuthor = scanner.nextLine();
    currentMember.findBookByTitleAuthor(titleOrAuthor, books);
    currentMember.memberBorrowBook(currentMember.findBookByTitleAuthor(titleOrAuthor, books));

}

public void myLoanedBooks() {

    if (borrowedBooks.size() == 0) {
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    } else {
        System.out.println("You have not borrow a book, yet..");
    }
    System.out.println("--------------");
}


public void returnBook() {
    myLoanedBooks();
    if (borrowedBooks.isEmpty()) {
        System.out.println("Book could not be found.");
    } else {
        System.out.println("Which book you will return? Please, enter the book title: ");
        String bookTitle = scanner.nextLine();
        currentMember.memberReturnBook(currentMember.findBookByTitleAuthor(bookTitle, borrowedBooks));
    }
}

    private void librarian () {
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
                //findMember(null);
                break;
            case "2":
                //addMember();
                break;
            case "3":
                //seeBorrowedBooks();
                break;
            case "4":
                //removeBook();
                break;
            case "5":
                //addNewBook();
                break;
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Wrong input. Please, enter a number between 0 to 7");
        }
    }

private void getUsers(){
    Path file = new File("user.ser").toPath();
    if (Files.exists(file)) {
        LibraryProgram libraryFromFile = (LibraryProgram) FileUtility.readObject("user.ser");
        this.members = libraryFromFile.members;
    } else {
        addUserToLibraryList();
    }
}

private void addUserToLibraryList(){
members.add(new Member("kurnia","123"));
}

}


  /*  //Find a certain member of the library. If not found, return null.
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
*/



