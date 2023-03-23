package com.bms.blog.service;

import com.bms.blog.dto.CommentDto;
import com.bms.blog.entity.Comment;
import com.bms.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<Comment> getReview(String uuid){
        return commentRepository.getReview(uuid);
    }

    public List<Comment> getRecentBoard(int count){
        return commentRepository.getRecentBoard(count);
    }

    public Comment setReview(CommentDto dto) {
        return commentRepository.save(modelMapper.map(dto, Comment.class));
    }

    public Comment deleteReview(String uuid) {
        Comment comment = commentRepository.findById(uuid).get();
        comment.setDeleteDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
