package com.bms.blog.repository;

import com.bms.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByNicknameAndPassword(String nickname, String password);

    @Query(value = "SELECT * FROM USER WHERE DELETE_DATE IS NULL", nativeQuery = true)
    List<User> getUser();
}

