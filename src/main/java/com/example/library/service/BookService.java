package com.example.library.service;

import com.example.library.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Boolean deleteBookById(Long id);
    Book updateBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
}
