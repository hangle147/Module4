package com.example.thong_tin_bai_hat.repository;

import com.example.thong_tin_bai_hat.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
