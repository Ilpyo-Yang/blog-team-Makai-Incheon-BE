package com.bms.blog.repository;

import com.bms.blog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
    @Query(value = "SELECT * FROM BOARD WHERE DELETE_DATE IS NULL", nativeQuery = true)
    List<Board> getBoard();

    @Query(value = "SELECT * FROM BOARD WHERE TAGS LIKE %:tag%", nativeQuery = true)
    List<Board> getBoardByTag(@Param("tag") String tag);

    @Query(value = "SELECT GROUP_CONCAT(TAGS SEPARATOR ',') FROM BOARD", nativeQuery = true)
    String getBoardTags();
}

