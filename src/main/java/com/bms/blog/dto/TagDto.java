package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import com.bms.blog.entity.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDto extends BaseEntity {
    private String tag;

    public TagDto(String tag){
        this.tag = tag;
    }
}
