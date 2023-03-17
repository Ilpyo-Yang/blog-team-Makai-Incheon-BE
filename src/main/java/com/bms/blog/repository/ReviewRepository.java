package com.bms.blog.repository;

import com.bms.blog.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT * FROM Review WHERE DELETE_DATE IS NULL", nativeQuery = true)
    List<Review> getReview();
}

