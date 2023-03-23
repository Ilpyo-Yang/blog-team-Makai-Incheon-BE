package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="COMMENT")
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseEntity{

    @Id
    @Column(name="UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "BOARD_UUID", referencedColumnName = "UUID")
    private Board board;

    @Column(name="TOP_COMMENT")
    private String topComment;

    @Column(name="USER_UUID")
    private String userId;

    @Column(name="NICKNAME")
    private String nickname;

    @Column(name="DELETE_DATE")
    LocalDateTime deleteDate;

    public Comment(String uuid, Board board, String topComment, String userId, String nickname, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.board = board;
        this.topComment = topComment;
        this.userId = userId;
        this.nickname = nickname;
        this.deleteDate = deleteDate;
    }
}
