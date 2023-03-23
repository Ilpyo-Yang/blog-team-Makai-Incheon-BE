package com.bms.blog.controller;

import com.bms.blog.dto.CommentDto;
import com.bms.blog.entity.Comment;
import com.bms.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final CommentService commentService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/board/{board_uuid}")
    public List<CommentDto> getReview(@PathVariable(value = "board_uuid") String uuid){
        List<Comment> list = commentService.getReview(uuid);
        List<CommentDto> dto = new ArrayList<>();
        list.forEach(i -> dto.add(modelMapper.map(i, CommentDto.class)));
        return dto;
    }

    @PostMapping
    public CommentDto setReview(@RequestParam("review") CommentDto dto){
        return modelMapper.map(commentService.setReview(dto), CommentDto.class);
    }

    @GetMapping("/recent/{count}")
    public List<CommentDto> getRecentBoard(@PathVariable(value = "count", required = false) int count){
        if(count==0){ count=10; }   // 초기값
        List<Comment> list = commentService.getRecentBoard(count);
        List<CommentDto> dto = new ArrayList<>();
        list.forEach(i -> dto.add(modelMapper.map(i, CommentDto.class)));
        return dto;
    }

    @PostMapping("/delete/{uuid}")
    public CommentDto deleteReview(@PathVariable(value = "uuid") String uuid){
        return modelMapper.map(commentService.deleteReview(uuid), CommentDto.class);
    }
}
