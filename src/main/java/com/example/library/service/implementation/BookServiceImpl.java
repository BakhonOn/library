package com.example.library.service.implementation;

import com.example.library.models.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Book createBook(Book book) {
        try {
            Book newBook = bookRepository.save(book);
            log.info("Создание книги: " + newBook);
            return newBook;
        } catch (DataAccessException e) {
            log.error("Ошибка при создании книги: ", e);
            return null;
        }
    }

    @Override
    @Transactional
    public Optional<Boolean> deleteBookById(Long id) {
        try {
            Book existingBook = bookRepository.findById(id).orElse(null);
            if (existingBook != null) {
                bookRepository.deleteById(id);
                log.info("Книга удалена: " + existingBook);
                return Optional.of(true);
            } else {
                log.info("Книга с ID " + id + " не найдена.");
                return Optional.of(false);
            }
        } catch (DataAccessException e) {
            log.error("Ошибка при удалении книги: ", e);
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<Book> updateBook(Book book) {
        try {
            Book existingBook = bookRepository.findById(book.getID()).orElse(null);
            if (existingBook != null) {
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
                existingBook.setGenre(book.getGenre());
                existingBook.setStatus(book.getStatus());
                existingBook.setYearOfPublication(book.getYearOfPublication());
                Book updatedBook = bookRepository.save(existingBook);
                log.info("Книга обновлена: " + updatedBook);
                return Optional.of(updatedBook);
            } else {
                log.info("Книга с ID " + book.getID() + " не найдена.");
                return Optional.empty();
            }
        } catch (DataAccessException e) {
            log.error("Ошибка при обновлении книги: ", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        try {
            return Optional.ofNullable(bookRepository.findById(id).orElse(null));
        } catch (DataAccessException e) {
            log.error("Ошибка при получении книги: ", e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Book>> getAllBooks() {
        try {
            return Optional.ofNullable(bookRepository.findAll());
        } catch (DataAccessException e) {
            log.error("Ошибка при получении всех книг: ", e);
            return Optional.empty();
        }
    }
}
