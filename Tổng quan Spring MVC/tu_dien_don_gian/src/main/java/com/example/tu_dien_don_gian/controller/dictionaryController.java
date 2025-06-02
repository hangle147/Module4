package com.example.tu_dien_don_gian.controller;

import com.example.tu_dien_don_gian.dao.DictionaryDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dictionaryController {
    private final DictionaryDAO dictionaryDAO = new DictionaryDAO();

    @PostMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String result = dictionaryDAO.findMeaning(word);
        model.addAttribute("result", result != null ? result : "Không tìm thấy từ");
        return "home";
    }
}
