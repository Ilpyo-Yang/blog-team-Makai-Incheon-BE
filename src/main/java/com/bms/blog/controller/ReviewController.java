package com.bms.blog.controller;

import com.bms.blog.dto.ReviewDto;
import com.bms.blog.entity.Review;
import com.bms.blog.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/board/{board_uuid}")
    public List<ReviewDto> getReview(@PathVariable(value = "board_uuid") String uuid){
        List<Review> list = reviewService.getReview(uuid);
        List<ReviewDto> dto = new ArrayList<>();
        list.forEach(i -> dto.add(modelMapper.map(i, ReviewDto.class)));
        return dto;
    }

    @PostMapping
    public ReviewDto setReview(@RequestParam("review") ReviewDto dto){
        return modelMapper.map(reviewService.setReview(dto), ReviewDto.class);
    }

    @GetMapping("/recent/{count}")
    public List<ReviewDto> getRecentBoard(@PathVariable(value = "count", required = false) int count){
        if(count==0){ count=10; }   // 초기값
        List<Review> list = reviewService.getRecentBoard(count);
        List<ReviewDto> dto = new ArrayList<>();
        list.forEach(i -> dto.add(modelMapper.map(i, ReviewDto.class)));
        return dto;
    }

    @PostMapping("/delete/{uuid}")
    public ReviewDto deleteReview(@PathVariable(value = "uuid") String uuid){
        return modelMapper.map(reviewService.deleteReview(uuid), ReviewDto.class);
    }
}
