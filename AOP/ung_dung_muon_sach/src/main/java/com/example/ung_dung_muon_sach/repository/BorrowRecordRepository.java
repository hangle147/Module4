package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    Optional<BorrowRecord> findByCode(String code);
}