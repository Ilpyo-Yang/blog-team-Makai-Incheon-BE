package com.bms.blog.repository;

import com.bms.blog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query(value = "SELECT * FROM BOARD WHERE DELETE_DATE IS NOT NULL", nativeQuery = true)
    List<Board> getBoard();
}

