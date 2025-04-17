package com.reviewrater.reviewrater_app.controller;

import com.reviewrater.reviewrater_app.model.Book;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @PostMapping()
    public Book saveBook(@RequestBody Book book){
        return book;

    }

    @GetMapping()
    public List<Book> getAllBooks(){
        List<Book> books = Arrays.asList(
                new Book(2L, "The Catcher in the Rye", "J.D. Salinger", "Fiction", LocalDate.of(1951, 7, 16), 5),
                new Book(3L, "To Kill a Mockingbird", "Harper Lee", "Fiction", LocalDate.of(1960, 7, 11), 4),
                new Book(4L, "1984", "George Orwell", "Dystopian", LocalDate.of(1949, 6, 8), 5),
                new Book(5L, "Pride and Prejudice", "Jane Austen", "Romance", LocalDate.of(1813, 1, 28), 5),
                new Book(6L, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", LocalDate.of(1925, 4, 10), 4)
        );
        return books;
    }

    @GetMapping("/{id}")
    public Book getSpecificBook(@PathVariable Long id)
    {
        return new Book(1L,"Harry Potter And Prisoners Of Azkaban","J.K Rowling","fiction", LocalDate.of(1999,01,10),9);
    }

}
