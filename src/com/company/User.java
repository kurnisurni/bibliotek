package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    Book findBookByTitleAuthor(String title, ArrayList<Book> books) {
        for (Book book : books) {
            if (book == null) {
                continue;
            }
            if (book.getTitle().toLowerCase().contains(title.toLowerCase()) || book.getAuthor().toLowerCase().contains(title.toLowerCase())) {
                return book;
            }
        }
        System.out.println("Book is not found.");
        return null;
    }


    @Override
    public String toString() {
        return "Username= " + userName + ", password= " + password;
    }
}
