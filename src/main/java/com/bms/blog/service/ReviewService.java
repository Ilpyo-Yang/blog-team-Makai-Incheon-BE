package com.bms.blog.service;

import com.bms.blog.dto.ReviewDto;
import com.bms.blog.entity.Review;
import com.bms.blog.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
        private final ReviewRepository reviewRepository;
        ModelMapper modelMapper = new ModelMapper();

        @Transactional
        public List<Review> getReview(){ return reviewRepository.findAll(); }

        @Transactional
        public void setReview(ReviewDto dto) { reviewRepository.save(modelMapper.map(dto, Review.class)); }

}
