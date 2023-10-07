package com.example.library.service.implementation;

import com.example.library.models.IssuanceRecord;
import com.example.library.repository.IssuanceRecordRepository;
import com.example.library.service.IssuanceRecordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j
public class IssuanceRecordImpl implements IssuanceRecordService {

    private final IssuanceRecordRepository issuanceRecordRepository;
    @Override
    public Optional<IssuanceRecord> createIssuanceRecord(IssuanceRecord issuanceRecord) {
        try{
            IssuanceRecord record=issuanceRecordRepository.save(issuanceRecord);
            log.info("Была создана запись!!!");
            return Optional.of(record);
        }catch (DataAccessException dataAccessException){
            log.error("ERROR: " + dataAccessException);
            return Optional.empty();
        }

    }

    @Override
    public Optional<IssuanceRecord> updateIssuanceRecord(IssuanceRecord issuanceRecord) {
        try{
            IssuanceRecord existingRecord=issuanceRecordRepository.findById(issuanceRecord.getID()).orElse(null);
            if(existingRecord!=null){
                existingRecord.setReaderId(issuanceRecord.getReaderId());
                existingRecord.setStatus(issuanceRecord.getStatus());
                existingRecord.setReturnDate(LocalDateTime.now());
                issuanceRecordRepository.save(existingRecord);
                log.info("Запись была обновлена!!!");
                return Optional.of(existingRecord);
            }else{
                log.info("нет такой записи!!!");
                return Optional.empty();
            }
        }catch(DataAccessException dataAccessException){
            log.error("ERROR: " + dataAccessException);
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<Boolean> deleteIssuanceRecordById(Long id) {
        try{
            IssuanceRecord existingRecord=issuanceRecordRepository.findById(id).orElse(null);
            if(existingRecord!=null){
                issuanceRecordRepository.deleteById(id);
                log.info("Запись была удалена!!!");
                return Optional.of(true);
            }else{
                log.info("Нет такой записи!!!");
                return Optional.empty();
            }
        }catch (DataAccessException dataAccessException){
            log.error("Error: " + dataAccessException);
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<IssuanceRecord>> getAllIssuanceRecords() {
        try {
            return Optional.of(issuanceRecordRepository.findAll());
        }catch (DataAccessException dataAccessException){
            log.error("Error: " + dataAccessException);
            return Optional.empty();
        }
    }
}
