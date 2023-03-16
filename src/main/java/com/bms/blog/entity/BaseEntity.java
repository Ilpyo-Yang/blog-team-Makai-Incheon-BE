package com.bms.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false, name="CREATED_DATE")
    LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false, name="CHANGED_DATE")
    LocalDateTime changedDate;

    @Column(insertable = false, name="DELETED_DATE")
    LocalDateTime deletedDate;
}
