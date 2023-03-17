package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="TAG")
@Getter
@Setter
@NoArgsConstructor
public class Tag extends BaseEntity{

    @Id
    @Column(name="UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column(name="TAG")
    private String tag;

    public Tag(String tag){
        this.tag = tag;
    }
}
