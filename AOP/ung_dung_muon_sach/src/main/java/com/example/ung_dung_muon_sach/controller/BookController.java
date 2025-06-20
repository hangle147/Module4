package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowRecord;
import com.example.ung_dung_muon_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String index(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/books/{id}/borrow-page")
    public String borrowPage(@PathVariable Long id, Model model) {
        Book book = bookService.getAllBooks().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
        model.addAttribute("book", book);
        return "borrow";
    }

    @PostMapping("/books/{id}/borrow")
    public String borrowBook(@PathVariable Long id, Model model) {
        try {
            BorrowRecord record = bookService.borrowBook(id);
            model.addAttribute("message", "Mượn thành công. Mã của bạn: " + record.getCode());
            return "return";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/books/return-page")
    public String returnPage() {
        return "return";
    }

    @PostMapping("/books/return")
    public String returnBook(@RequestParam String code, Model model) {
        try {
            bookService.returnBook(code);
            model.addAttribute("message", "Trả sách thành công!");
            return "return";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }
}

