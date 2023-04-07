package com.bms.blog.service;

import com.bms.blog.dto.CommentDto;
import com.bms.blog.entity.Comment;
import com.bms.blog.repository.BoardRepository;
import com.bms.blog.repository.CommentRepository;
import com.bms.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public List<CommentDto> getComment(String uuid){
        List<Comment> list = commentRepository.getComment(uuid);
        return mapper(list);
    }

    public List<Comment> getRecentBoard(int count){
        return commentRepository.getRecentBoard(count);
    }

    public CommentDto setComment(String uuid, String boardId, String userId, String comment, String topComment) {
        Comment dto;

        if(uuid==null){
            dto = new Comment();
            dto.setTopComment(topComment);
            dto.setUserId(userId);
            dto.setBoard(boardRepository.findById(boardId).get());
        }
        else{
            dto = commentRepository.findById(uuid).get();
        }

        dto.setComment(comment);

        // signin user 연결로 변경예정
        // 닉네임은 등록일자에 따라 변경될 수 있다.
        dto.setNickname(userRepository.findById(userId).get().getNickname());

        commentRepository.save(dto);
        List<Comment> list = new ArrayList<>();
        list.add(dto);
        return mapper(list).get(0);
    }

    public Comment deleteComment(String uuid) {
        Comment comment = commentRepository.findById(uuid).get();
        comment.setDeleteDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    private List<CommentDto> mapper(List<Comment> list){
        List<CommentDto> dtoList = new ArrayList<>();
        for(Comment b: list){
            CommentDto dto = new CommentDto().builder()
                    .uuid(b.getUuid())
                    .boardId(b.getBoard().getUuid())
                    .topComment(b.getTopComment())
                    .userId(b.getUserId())
                    .nickname(b.getNickname())
                    .comment(b.getComment())
                    .createdDate(b.getCreatedDate())
                    .editDate(b.getEditDate())
                    .deleteDate(b.getDeleteDate())
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }
}
