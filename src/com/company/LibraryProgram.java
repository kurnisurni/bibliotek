package com.company;


import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryProgram implements Serializable {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private Member currentMember;
    private transient Scanner scanner = new Scanner(System.in);

public LibraryProgram(){
        renderBookAndUser();
start();
    }

    private void renderBookAndUser() {
        Path file = new File("library.ser").toPath();
        if (Files.exists(file)) {
            LibraryProgram libraryFromFile = (LibraryProgram) FileUtility.readObject("library.ser");
            this.books = libraryFromFile.books;
            this.members = libraryFromFile.members;
        } else {
            addBookUserToLibrary();
        }
    }

    private void addBookUserToLibrary() {
        books.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", "Thousands of years before the events of the novel, the Dark Lord Sauron had forged the One Ring to rule the other Rings of Power and corrupt those who wore them: three for Elves, seven for Dwarves, and nine for Men. Sauron was defeated by an alliance of Elves and Men led by Gil-galad and Elendil, respectively. In the final battle, Isildur, son of Elendil, cut the One Ring from Sauron's finger, causing Sauron to lose his physical form. Isildur claimed the Ring as an heirloom for his line, but when he was later ambushed and killed by the Orcs, the Ring was lost in the River Anduin."));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupéry", "The story follows a young prince who visits various planets in space, including Earth, and addresses themes of loneliness, friendship, love, and loss. Despite its style as a children's book, The Little Prince makes poignant observations about life and human nature."));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry. Harry makes close friends and a few enemies during his first year at the school, and with the help of his friends, Harry faces an attempted comeback by the dark wizard Lord Voldemort, who killed Harry's parents, but failed to kill Harry when he was just 15 months old."));
        books.add(new Book("The Master and Margarita", "Mikhail Bulgakov", "The story concerns a visit by the devil to the officially atheistic Soviet Union. The Master and Margarita combines supernatural elements with satirical dark comedy and Christian philosophy, defying a singular genre. Many critics consider it to be one of the best novels of the 20th century, as well as the foremost of Soviet satires."));
        books.add(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", " It tells of a young girl named Alice falling through a rabbit hole into a fantasy world populated by peculiar, anthropomorphic creatures. The tale plays with logic, giving the story lasting popularity with adults as well as with children. It is considered to be one of the best examples of the literary nonsense genre."));
        books.add(new Book("The Hobbit", "J. R. R. Tolkien", "The story is told in the form of an episodic quest, and most chapters introduce a specific creature or type of creature of Tolkien's geography. Bilbo gains a new level of maturity, competence, and wisdom by accepting the disreputable, romantic, fey, and adventurous sides of his nature and applying his wits and common sense. The story reaches its climax in the Battle of Five Armies, where many of the characters and creatures from earlier chapters re-emerge to engage in conflict."));
        books.add(new Book("And Then There Were None", "Agatha Christie", "On 8 August in the late 1930s, eight people arrive on a small, isolated island off the Devon coast of England. Each has an invitation tailored to his or her personal circumstances, such as an offer of employment or an unexpected late summer holiday. They are met by Thomas and Ethel Rogers, the butler and cook-housekeeper, who state that their hosts, Mr. Ulick Norman Owen and his wife Mrs. Una Nancy Owen, whom they have not yet met in person, have not arrived, but left instructions, which strikes all the guests as odd."));
        books.add(new Book("Dream of the Red Chamber", "Cao Xueqin", "Red Chamber is believed to be semi-autobiographical, mirroring the rise and decline of author Cao Xueqin's own family and, by extension, of the Qing dynasty. As the author details in the first chapter, it is intended to be a memorial to the damsels he knew in his youth: friends, relatives and servants. The novel is remarkable not only for its huge cast of characters and psychological scope, but also for its precise and detailed observation of the life and social structures typical of 18th-century Chinese society."));
        books.add(new Book("The Da Vinci Code", "Dan Brown", "The Da Vinci Code follows 'symbologist' Robert Langdon and cryptologist Sophie Neveu after a murder in the Louvre Museum in Paris causes them to become involved in a battle between the Priory of Sion and Opus Dei over the possibility of Jesus Christ having been a companion to Mary Magdalene. The novel explores an alternative religious history, whose central plot point is that the Merovingian kings of France were descended from the bloodline of Jesus Christ and Mary Magdalene."));
        books.add(new Book("The Alchemist", "Paulo Coelho", "An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there."));
        books.add(new Book("The Lion, the Witch and the Wardrobe", "C. S. Lewis", "Most of the novel is set in Narnia, a land of talking animals and mythical creatures that is ruled by the evil White Witch. In the frame story, four English children are relocated to a large, old country house following a wartime evacuation. The youngest, Lucy, visits Narnia three times via the magic of a wardrobe in a spare room. Lucy's three siblings are with her on her third visit to Narnia. In Narnia, the siblings seem fit to fulfill an old prophecy and find themselves adventuring to save Narnia and their own lives. The lion Aslan gives his life to save one of the children; he later rises from the dead, vanquishes the White Witch, and crowns the children Kings and Queens of Narnia."));
        members.add(new Member("Bibi", "123"));
        members.add(new Member("Bobo", "123"));
    }


    private void start() {

        boolean running = true;
        System.out.println("Welcome to OOP-Java library");
        System.out.println("-----------------------------");

        while (running) {
            System.out.println("Please select the menu: ");
            System.out.println("1. Member");
            System.out.println("2. Librarian");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    memberLogIn();
                    FileUtility.writeObject(this, "library.ser");
                    break;
                case "2":
                    librarian(books);
                    FileUtility.writeObject(this, "library.ser");
                    System.exit(0);
                    break;
                case "0":
                    FileUtility.writeObject(this, "library.ser");
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 2");
            }
        }
    }

    private void memberLogIn() {
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
            System.out.println("5. My books account");
            System.out.println("0. Save and exit");


            String memberChoice = scanner.nextLine();
            switch (memberChoice) {
                case "1":
                    showAllBooks(books);
                    break;
                case "2":
                    showAvailableBooks();
                    break;
                case "3":
                    searchForBook();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    currentMember.myAccount();
                    break;
                case "0":
                    FileUtility.writeObject(this, "library.ser");
                    System.out.println("Thanks and hope to see you again!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 6");
            }
        }
    }

    private void showAllBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
            System.out.println(book.getDescription());
            System.out.println("---------------------------------------------------------------");
        }
    }

    private void showAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    private void searchForBook() {
        System.out.println("Please, enter a book title or author");
        String searchedBook = scanner.nextLine();
        Book book = currentMember.findBookByTitleAuthor(searchedBook, books);
        if (book == null) {
            System.out.println("Sorry, " + searchedBook + " is not found.");
        } else {
            System.out.println(book);
            System.out.println("Description: ");
            System.out.println(currentMember.findBookByTitleAuthor(searchedBook, books).getDescription());
        }
    }


    public void borrowBook() {
        showAvailableBooks();
        System.out.println("Please, enter a book title or author:");
        String titleOrAuthor = scanner.nextLine();
        currentMember.findBookByTitleAuthor(titleOrAuthor, books);
        currentMember.memberBorrowBook(currentMember.findBookByTitleAuthor(titleOrAuthor, books));

    }


    public void librarian(ArrayList<Book> libraryBooks) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Hi, librarian! Please, select the menu: ");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. See all books");
            System.out.println("4. Add a new member");
            System.out.println("5. See all members");
            System.out.println("6. Search a member");
            System.out.println("0. Save & Exit");
            String librarianChoice = scanner.nextLine();
            switch (librarianChoice) {
                case "1":
                    System.out.println("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter Summary: ");
                    String summary = scanner.nextLine();
                    addBookToLibrary(libraryBooks, title, author, summary);
                    break;
                case "2":
                    printAllLibraryBooks(libraryBooks);
                    System.out.println("Enter Title: ");
                    String bookToRemoveTitle = scanner.nextLine();
                    removeBookFromLibrary(bookToRemoveTitle, libraryBooks);
                    break;
                case "3":
                    printAllLibraryBooks(libraryBooks);
                    break;
                case "4":
                    System.out.println("Enter a username: ");
                    String memberName = scanner.nextLine();
                    System.out.println("Enter password");
                    String memberPassword = scanner.nextLine();
                    addMemberToLibrary(memberName,memberPassword);
                    break;
                case "5":
                    allMembers(members);
                    break;
                case "6":
                    System.out.println("Enter the member's name: ");
                    String libMember = scanner.nextLine();
                    Member member = findUser(libMember, members);
                    System.out.println(member);
                    break;
                case "0":
                    System.out.println("You are successfully exit the system!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input. Please, enter a number between 0 to 6");
                    break;
            }
        }
    }

    void printAllLibraryBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
            System.out.println(book.getDescription());
            System.out.println("------------------------------------------");
        }
    }

    void removeBookFromLibrary(String title, ArrayList<Book> libraryBooks) {
        Book book = findBookByTitleAuthor(title, libraryBooks);
        libraryBooks.remove(book);
        System.out.println(book.getTitle() + " is removed.");
    }

    private Book findBookByTitleAuthor(String title, ArrayList<Book> books) {
        for(Book book:books){
            if(book==null){
                continue;
            }
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()) || book.getAuthor().toLowerCase().contains(title.toLowerCase())){
                return book;
            }
        }
        System.out.println("Book is not found.");
        return null ;
    }

    void addBookToLibrary(ArrayList<Book> books, String title, String author, String description) {
        books.add(new Book(title, author, description));
        System.out.println(title + " added to library collection");
    }

    void addMemberToLibrary(String memberName, String memberPassword) {
        members.add(new Member(memberName, memberPassword));
        System.out.println(memberName + " added to the library systema");
    }

    public void allMembers(ArrayList<Member> members) {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public Member findUser(String libMember, ArrayList<Member> members) {
        for (Member member : members) {
            if (member.getUserName().toLowerCase().equals(libMember.toLowerCase()))
                return member;
        }
        return null;
    }


    }









