package com.example.library.service.implementation;

import com.example.library.models.Reader;
import com.example.library.repository.ReaderRepository;
import com.example.library.service.ReaderService;
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
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;
    @Override
    public Optional<Reader> createReader(Reader reader) {
        try{
            Reader newReader=readerRepository.save(reader);
            log.info("Был создан читатель!!!");
            return Optional.of(newReader);
        }catch (DataAccessException e){
            log.error("Error: " + e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Reader> updateReader(Reader reader) {
        try {
            Reader existing=readerRepository.findById(reader.getID()).orElse(null);
            if (existing!=null){
                existing.setEmail(reader.getEmail());
                existing.setDebt(reader.getDebt());
                existing.setPhone(reader.getPhone());
                existing.setFirstName(reader.getFirstName());
                existing.setLastName(reader.getLastName());
                readerRepository.save(existing);
                log.info("Данные читателя были обновлены!!!");
                return Optional.of(existing);
            }else {
                log.info("Нет такого пользователя!!!");
                return Optional.empty();
            }
        }catch (DataAccessException dataAccessException){
            log.error("Error: " + dataAccessException);
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<Boolean> deleteReader(Long id) {
        try {
            Reader existing=readerRepository.findById(id).orElse(null);
            if (existing!=null){
                readerRepository.deleteById(id);
                log.info("Данные читателя были удалены!!!");
                return Optional.of(true);
            }else {
                log.info("Нет такого пользователя!!!");
                return Optional.empty();
            }
        }catch (DataAccessException dataAccessException){
            log.error("Error: " + dataAccessException);
            return Optional.empty();
        }
    }
    @Override
    public Optional<List<Reader>> getAllReader() {
        try {
            return Optional.of(readerRepository.findAll());
        }catch (DataAccessException dataAccessException){
            log.error("Error: " + dataAccessException);
            return Optional.empty();
        }
    }
}
