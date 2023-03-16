package com.bms.blog.dto;

import com.bms.blog.entity.BaseEntity;
import com.bms.blog.entity.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewDto extends BaseEntity {
    private Long uuid;
    private Board board;
    private String top_comment;
    private String nickname;

    public ReviewDto(Long uuid, Board board, String top_comment, String nickname){
        this.uuid = uuid;
        this.board = board;
        this.top_comment = top_comment;
        this.nickname = nickname;
    }
}
