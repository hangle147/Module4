package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowRecord;
import com.example.ung_dung_muon_sach.repository.BookRepository;
import com.example.ung_dung_muon_sach.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BorrowRecordRepository recordRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public BorrowRecord borrowBook(Long bookId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book is out of stock");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setCode(generateCode());
        return recordRepo.save(record);
    }

    public void returnBook(String code) {
        BorrowRecord record = recordRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Invalid borrow code"));

        Book book = bookRepo.findById(record.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);
        recordRepo.delete(record);
    }

    private String generateCode() {
        return String.valueOf(10000 + new Random().nextInt(90000));
    }
}

