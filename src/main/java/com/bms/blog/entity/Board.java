package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="BOARD")
@Getter
@Setter
@NoArgsConstructor
public class Board extends BaseEntity{

    @Id
    @Column(name="UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @ManyToOne
    @JoinColumn(name = "USER_UUID", referencedColumnName = "UUID")
    private User user;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENTS_PATH")
    private String contentsPath;

    @Column(name="TAGS")
    private String tags;

    @Column(name="VIEW_COUNT")
    private String viewCount;

    @Column(name="DELETE_DATE")
    LocalDateTime deletedDate;

    public Board(Long uuid, User user, String title, String contentsPath, String tags, String viewCount, LocalDateTime deletedDate){
        this.uuid = uuid;
        this.user = user;
        this.title = title;
        this.contentsPath = contentsPath;
        this.tags = tags;
        this.viewCount = viewCount;
        this.deletedDate = deletedDate;
    }
}
