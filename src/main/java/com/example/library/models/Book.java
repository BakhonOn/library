package com.example.library.models;

import com.example.library.models.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
//TODO: тут такая трабла что, дату лучше не использовать с расширенными классамми, так как в нем лежит @EqHashcode
@Table(name = "books")
@Entity
@NoArgsConstructor
public class Book extends BaseEntity {

    //    @NotNull
    //TODO: Можно использовать nullable = false вместо @NotNull, а сам @NotNull повесить над ДТОшкой между контролллером и сервисом
    @Column(name = "title", nullable = false)
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

    @Column(name = "year_of_publication", columnDefinition = "SMALLINT")
    @NotNull
    //TODO: можно для оптимизации дописать в columnDefinition = "SMALLINT" занимает 2 байта и может хранить значения от -32,768 до 32,767
    private Integer yearOfPublication;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;


    //TODO: лучше вынести в отдельный файл, и для таких енамок создать свой пакет
    public enum BookStatus {
        AVAILABLE,
        ISSUED
    }

    //TODO: можно использовать аннотацию @AllArgsConstructor
    public Book(String title, String author, String genre, Integer yearOfPublication, BookStatus status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
    }
}
