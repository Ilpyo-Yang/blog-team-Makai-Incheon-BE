package com.bms.blog.repository;

import com.bms.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
    @Query(value = "SELECT TAG FROM TAG", nativeQuery = true)
    List<String> getTag();
}

