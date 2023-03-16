package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="REVIEW")
@Getter
@Setter
@NoArgsConstructor
public class Review extends BaseEntity{

    @Id
    @Column(name="UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @ManyToOne
    @JoinColumn(name = "BOARD_UUID", referencedColumnName = "UUID")
    private Board board;

    @Column(name="TOP_COMMENT")
    private String top_comment;

    @Column(name="NICKNAME")
    private String nickname;

    @Column(name="DELETE_DATE")
    LocalDateTime deletedDate;

    public Review(Long uuid, Board board, String top_comment, String nickname, LocalDateTime deletedDate){
        this.uuid = uuid;
        this.board = board;
        this.top_comment = top_comment;
        this.nickname = nickname;
        this.deletedDate = deletedDate;
    }
}
