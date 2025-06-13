package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    Blog save(Blog blog);
    void delete(Long id);
    List<Blog> searchByTitle(String keyword);
    List<Blog> findByCategoryId(Long categoryId);
}