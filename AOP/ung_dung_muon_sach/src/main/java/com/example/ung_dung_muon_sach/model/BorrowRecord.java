package com.example.ung_dung_muon_sach.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BorrowRecord {
    @Id
    @GeneratedValue
    private long id;

    private String code;
    private long bookId;
}
