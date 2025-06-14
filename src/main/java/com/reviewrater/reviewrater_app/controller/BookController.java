package com.reviewrater.reviewrater_app.controller;

import com.reviewrater.reviewrater_app.model.Book;
import com.reviewrater.reviewrater_app.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping()
    public List<Book> getAllBooks(@RequestParam(required = false) String author,@RequestParam(required = false) String genre){
        return bookService.getAllBooks(author,genre);
    }

    @GetMapping("/{id}")
    public Book getSpecificBook(@PathVariable Long id)
    {
        return bookService.getBookById(id);
    }

    @GetMapping("/user")
    public String greetUser(@RequestHeader("X-User") String user)
    {
        return bookService.greetCurrentUser(user);
    }

    @GetMapping("/{id}/summary")
    public String getBookSummary(@PathVariable long id)
    {
        return bookService.getBookSummary(id);
    }
}
