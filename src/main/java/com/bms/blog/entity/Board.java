package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String contents_path;

    @Column(name="TAGS")
    private String tags;

    @Column(name="VIEW_COUNT")
    private String view_count;

    public Board(Long uuid, User user, String title, String contents_path, String tags, String view_count){
        this.uuid = uuid;
        this.user = user;
        this.title = title;
        this.contents_path = contents_path;
        this.tags = tags;
        this.view_count = view_count;
    }
}
