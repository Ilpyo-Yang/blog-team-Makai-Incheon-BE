package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TAG")
@Getter
@Setter
@NoArgsConstructor
public class Tag{
    @Id
    @Column(name="TAG")
    private String tag;

    public Tag(String tag){
        this.tag = tag;
    }
}
