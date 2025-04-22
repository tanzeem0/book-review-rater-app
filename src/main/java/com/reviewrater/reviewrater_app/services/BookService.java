package com.reviewrater.reviewrater_app.services;

import com.reviewrater.reviewrater_app.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    Book getBookById(Long id);

    List<Book> getAllBooks(String author,String genre);

    String greetCurrentUser(String user);

    String getBookSummary(long id);
}
