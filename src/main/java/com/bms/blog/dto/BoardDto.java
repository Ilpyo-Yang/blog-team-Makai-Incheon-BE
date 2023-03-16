package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import com.bms.blog.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDto extends BaseEntity {
    private Long uuid;
    private User user;
    private String title;
    private String contentsPath;
    private String tags;
    private String viewCount;
    private LocalDateTime createdDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public BoardDto(Long uuid, User user, String title, String contentsPath, String tags, String viewCount,
                    LocalDateTime createdDate, LocalDateTime editDate, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.user = user;
        this.title = title;
        this.contentsPath = contentsPath;
        this.tags = tags;
        this.viewCount = viewCount;
        this.createdDate = createdDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
}
