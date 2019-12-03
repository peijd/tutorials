package com.ripjava.patterm.frontcontroller.commands;

import com.ripjava.patterm.frontcontroller.model.Book;
import com.ripjava.patterm.frontcontroller.repository.BookRepository;

import javax.servlet.ServletException;
import java.io.IOException;

public class SearchCommand extends AbstractCommand{
    @Override
    public void process() throws ServletException, IOException {
        Book book = BookRepository.getInstance()
                .findByTitle(request.getParameter("title"));
        if (book != null) {
            request.setAttribute("book", book);
            forward("book-found");
        } else {
            forward("book-notfound");
        }
    }
}
