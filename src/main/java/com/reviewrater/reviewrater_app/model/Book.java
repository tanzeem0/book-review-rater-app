package com.reviewrater.reviewrater_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    private String author;

    private String genre;

    private LocalDate publishedDate;

    private Integer rating;
}
