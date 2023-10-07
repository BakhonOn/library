package com.example.library.service;

import com.example.library.models.IssuanceRecord;

import java.util.Optional;
import java.util.List;

public interface IssuanceRecordService {
    Optional<IssuanceRecord> createIssuanceRecord(IssuanceRecord issuanceRecord);
    Optional<IssuanceRecord> updateIssuanceRecord(IssuanceRecord issuanceRecord);
    Optional<Boolean> deleteIssuanceRecordById(Long id);
    Optional<List<IssuanceRecord>> getAllIssuanceRecords();
}
