package com.example.library.service;

import com.example.library.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> createBook(Book book);
    Optional<Boolean> deleteBookById(Long id);
    Optional<Book> updateBook(Book book);
    Optional<Book> getBookById(Long id);
    Optional<List<Book>>  getAllBooks();
}
