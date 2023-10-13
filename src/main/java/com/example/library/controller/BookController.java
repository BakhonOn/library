package com.example.library.controller;

import com.example.library.models.Book;
import com.example.library.service.BookService;
import com.example.library.service.IssuanceRecordService;
import com.example.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/book")
@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    @PostMapping("new_book")
    public ResponseEntity<Book> postNewBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }
    @GetMapping("get_book")
    public ResponseEntity<Optional<Book>> getBookById(@RequestParam Long id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }
    @PutMapping("update_book")
    public ResponseEntity<Optional<Book>> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }
    @GetMapping("get_all_books")
    public ResponseEntity<Optional<List<Book>>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @DeleteMapping("delete_book_by_id")
    public ResponseEntity<Optional<Boolean>> deleteBook(@RequestParam Long id){
        return new ResponseEntity<>(bookService.deleteBookById(id), HttpStatus.OK);
    }
}
