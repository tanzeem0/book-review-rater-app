package com.reviewrater.reviewrater_app.services;

import com.reviewrater.reviewrater_app.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl  implements BookService {

    List<Book> books = new ArrayList<>();

    private final RestTemplate restTemplate;

    @Value("${book.api.url}")
    private String baseUrl;

    @Override
    public Book saveBook(Book book) {
         book.setId((long) books.size());
         books.add(book);
         return books.getLast();
    }

    @Override
    public Book getBookById(Long id) {
        return books.stream().filter(book-> Objects.equals(book.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<Book> getAllBooks(String author,String genre) {
        return books.stream()
                .filter(book->(author == null || book.getAuthor().equalsIgnoreCase(author)))
                .filter(book -> genre == null || book.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    @Override
    public String greetCurrentUser(String user) {
        return "Hello, " + user + "!" + " Welcome to ReviewRater";
    }

    @Override
    public String getBookSummary(long id) {
        ResponseEntity<Book> response = restTemplate.getForEntity(baseUrl+ id,Book.class);
        Book book = response.getBody();
        if(response.getBody() != null)
            return "The book " + book.getTitle() + " by " + book.getAuthor() + " is a " + book.getGenre() + " book with a rating of " + book.getRating();
        return "Book not found";
    }
}
