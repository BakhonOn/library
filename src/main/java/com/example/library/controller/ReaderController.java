package com.example.library.controller;

import com.example.library.models.Book;
import com.example.library.models.Reader;
import com.example.library.service.BookService;
import com.example.library.service.IssuanceRecordService;
import com.example.library.service.ReaderService;
import com.fasterxml.jackson.annotation.OptBoolean;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reader")
public class ReaderController {
    private final ReaderService readerService;
    @PostMapping("new_reader")
    public ResponseEntity<Optional<Reader>> createReader(@RequestBody Reader reader){
        return new ResponseEntity<>(readerService.createReader(reader), HttpStatus.OK);
    }

    @PutMapping("update_reader")
    public ResponseEntity<Optional<Reader>> updateReader(@RequestBody Reader reader){
        return new ResponseEntity<>(readerService.updateReader(reader),HttpStatus.OK);
    }

    @DeleteMapping("delete_reader")
    public ResponseEntity<Optional<Boolean>> deleteReaderById(@RequestParam Long id){
        return new ResponseEntity<>(readerService.deleteReader(id),HttpStatus.OK);
    }

    @GetMapping("get_reader")
    public ResponseEntity<Optional<Reader>> getReaderById(@RequestParam Long id){
        return new ResponseEntity<>(readerService.getReaderById(id),HttpStatus.OK);
    }

    @GetMapping("get_readers")
    public ResponseEntity<Optional<List<Reader>>> getAllReaders(){
        return new ResponseEntity<>(readerService.getAllReader(),HttpStatus.OK);
    }

}
