package com.bms.blog.service;

import com.bms.blog.dto.ReviewDto;
import com.bms.blog.entity.Board;
import com.bms.blog.entity.Review;
import com.bms.blog.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<Review> getReview(Long uuid){ return reviewRepository.getReview(uuid); }

    public List<Review> getRecentBoard(int count){ return reviewRepository.getRecentBoard(count); }

    public Review setReview(ReviewDto dto) {
        return reviewRepository.save(modelMapper.map(dto, Review.class));
    }

    public Review deleteReview(Long uuid) {
        Review review = reviewRepository.findById(uuid).get();
        review.setDeleteDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }
}
