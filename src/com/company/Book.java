package com.company;

public class Book {
    private String title;
    private String genre;
    private String author;
    private String description;
    private boolean available;

    public Book(String title, String genre, String author, String description) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.description = description;
        setAvailable(true);
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public boolean getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
