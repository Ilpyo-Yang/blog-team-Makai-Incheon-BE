package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import com.bms.blog.entity.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReviewDto extends BaseEntity {
    private Long uuid;
    private Board board;
    private String topComment;
    private String nickname;
    private LocalDateTime createdDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public ReviewDto(Long uuid, Board board, String topComment, String nickname,
                     LocalDateTime createdDate, LocalDateTime editDate, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.board = board;
        this.topComment = topComment;
        this.nickname = nickname;
        this.createdDate = createdDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
}
