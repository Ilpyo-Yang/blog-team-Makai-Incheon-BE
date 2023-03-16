package com.bms.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TAG")
@Getter
@Setter
@NoArgsConstructor
public class Tag extends BaseEntity{

    @Id
    @Column(name="TAG")
    private String tag;

    public Tag(String tag){
        this.tag = tag;
    }
}
