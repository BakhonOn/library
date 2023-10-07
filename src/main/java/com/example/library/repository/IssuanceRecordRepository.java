package com.example.library.repository;

import com.example.library.models.IssuanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuanceRecordRepository extends JpaRepository<IssuanceRecord,Long> {
}
