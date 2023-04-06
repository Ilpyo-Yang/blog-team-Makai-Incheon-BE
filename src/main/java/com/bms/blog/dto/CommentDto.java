package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentDto extends BaseEntity {
    private String uuid;
    private String boardId;
    private String topComment;
    private String userId;
    private String nickname;
    private LocalDateTime createdDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public CommentDto(String uuid, String boardId, String topComment, String userId, String nickname,
                      LocalDateTime createdDate, LocalDateTime editDate, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.boardId = boardId;
        this.topComment = topComment;
        this.userId = userId;
        this.nickname = nickname;
        this.createdDate = createdDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
}
