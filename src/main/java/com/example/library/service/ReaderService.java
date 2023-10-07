package com.example.library.service;

import com.example.library.models.Reader;

import java.util.List;
import java.util.Optional;

public interface ReaderService {
    Optional<Reader> createReader(Reader reader);
    Optional<Reader> updateReader(Reader reader);
    Optional<Boolean> deleteReader(Long id);
    Optional<List<Reader>> getAllReader();
    Optional<Reader> getReaderById(Long id);
}
