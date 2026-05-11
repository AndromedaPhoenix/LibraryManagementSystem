package com.naps.Library;

import java.time.LocalDate;

public class Book { String isbn, title, author;
    boolean borrowed;
    LocalDate dueDate;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return isbn + " | " + title + " | " + author +
                (borrowed ? " | Borrowed (due " + dueDate + ")" : " | Available");
    }
}