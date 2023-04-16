package com.example.Pribori.service;

import com.example.Pribori.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto saveComment(CommentDto commentDto);
    void deleteComment(Long id);
    CommentDto findByNameC(String name);
    List<CommentDto> findAllC();
}
