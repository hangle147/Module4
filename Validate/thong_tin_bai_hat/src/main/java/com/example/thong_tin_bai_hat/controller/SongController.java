package com.example.thong_tin_bai_hat.controller;

import com.example.thong_tin_bai_hat.model.Song;
import com.example.thong_tin_bai_hat.repository.SongRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@Valid @ModelAttribute Song song,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songRepository.save(song);
        return "redirect:/songs/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songRepository.findById(id).orElseThrow();
        model.addAttribute("song", song);
        return "create";
    }

    @PostMapping("/edit/{id}")
    public String updateSong(@PathVariable Long id,
                             @Valid @ModelAttribute Song song,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        song.setId(id);
        songRepository.save(song);
        return "redirect:/songs/list";
    }

    @GetMapping("/list")
    public String listSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "list";
    }
}