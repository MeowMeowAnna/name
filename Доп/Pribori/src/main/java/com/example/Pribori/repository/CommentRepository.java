package com.example.Pribori.repository;

import com.example.Pribori.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByName(String name);
    List<Comment> findByNameContains(String name);
}
