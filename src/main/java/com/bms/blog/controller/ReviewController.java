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

    @GetMapping
    public List<ReviewDto> getBoard(){
       List<Review> list = reviewService.getReview();
       List<ReviewDto> dto = new ArrayList<>();
       list.forEach(i -> dto.add(modelMapper.map(i, ReviewDto.class)));
       return dto;
    }

    @PostMapping("/{uuid}")
    public void setReview(@PathVariable(value = "uuid", required = false) Long uuid, @RequestParam("review") ReviewDto dto){
        reviewService.setReview(dto);
    }

    @PostMapping("/delete")
    public void deleteReview(@RequestParam(value = "uuid") Long uuid){
        reviewService.deleteReview(uuid);
    }
}
