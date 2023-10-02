package com.example.library.models;

import com.example.library.models.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Table(name = "books")
@Entity
@NoArgsConstructor
public class Book extends BaseEntity {

    @Column(name = "title")
    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @Column(name = "author")
    @NotNull
    @Size(min = 1, max = 255)
    private String author;

    @Column(name = "genre")
    @NotNull
    @Size(min = 1, max = 50)
    private String genre;

    @Column(name = "year_of_publication")
    @NotNull
    private Integer yearOfPublication;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public enum BookStatus {
        AVAILABLE,
        ISSUED
    }

    public Book(String title, String author, String genre, Integer yearOfPublication, BookStatus status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
    }
}
