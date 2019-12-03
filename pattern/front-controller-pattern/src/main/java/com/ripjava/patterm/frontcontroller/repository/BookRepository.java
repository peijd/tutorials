package com.ripjava.patterm.frontcontroller.repository;

import com.ripjava.patterm.frontcontroller.model.Book;

import java.util.ArrayList;

public class BookRepository extends ArrayList<Book> {
    private static BookRepository INSTANCE;

    private void init() {
        add(new Book("jason", "Java", 9.99));
        add(new Book("jason", "Servlet", 27.88));
    }

    private BookRepository(){

    }


    public static BookRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookRepository();
            INSTANCE.init();
        }
        return INSTANCE;
    }


    public Book findByTitle(String title) {
        return this.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
}
