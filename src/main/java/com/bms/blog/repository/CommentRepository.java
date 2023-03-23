package com.bms.blog.repository;

import com.bms.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    @Query(value = "SELECT * FROM Comment WHERE DELETE_DATE IS NULL AND BOARD_UUID=:uuid", nativeQuery = true)
    List<Comment> getComment(@Param("uuid") String uuid);

    @Query(value = "SELECT * FROM Comment WHERE DELETE_DATE IS NULL ORDER BY CREATE_DATE DESC LIMIT :count", nativeQuery = true)
    List<Comment> getRecentBoard(@Param("count") int count);
}

