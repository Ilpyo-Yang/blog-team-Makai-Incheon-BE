package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import com.bms.blog.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
public class BoardDto extends BaseEntity {
    private String uuid;
    private String userId;
    private String userNickname;
    private String title;
    private String contentsPath;
    private String tags;
    private String viewCount;
    private LocalDateTime createdDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public BoardDto(String uuid, String userId, String userNickname, String title, String contentsPath, String tags, String viewCount,
                    LocalDateTime createdDate, LocalDateTime editDate, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.userId = userId;
        this.userNickname = userNickname;
        this.title = title;
        this.contentsPath = contentsPath;
        this.tags = tags;   // '["Apple","Banana","Orange"]' // 배열 문자열
        this.viewCount = viewCount;
        this.createdDate = createdDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
}
