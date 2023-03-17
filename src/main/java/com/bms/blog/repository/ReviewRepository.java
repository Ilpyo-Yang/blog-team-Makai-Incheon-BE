package com.bms.blog.repository;

import com.bms.blog.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT * FROM Review WHERE DELETE_DATE IS NULL AND BOARD_UUID=:uuid", nativeQuery = true)
    List<Review> getReview(@Param("uuid") Long uuid);

    @Query(value = "SELECT * FROM Review WHERE DELETE_DATE IS NULL ORDER BY CREATE_DATE DESC LIMIT :count", nativeQuery = true)
    List<Review> getRecentBoard(@Param("count") int count);
}

