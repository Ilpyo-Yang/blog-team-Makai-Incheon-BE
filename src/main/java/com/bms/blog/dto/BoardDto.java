package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import com.bms.blog.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto extends BaseEntity {
    private Long uuid;
    private User user;
    private String title;
    private String contents_path;
    private String tags;
    private String view_count;

    public BoardDto(Long uuid, User user, String title, String contents_path, String tags, String view_count){
        this.uuid = uuid;
        this.user = user;
        this.title = title;
        this.contents_path = contents_path;
        this.tags = tags;
        this.view_count = view_count;
    }
}
