package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{

    @Id
    @Column(name="UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column(name="NICKNAME")
    private String nickname;

    @Column(name="Password")
    private String password;

    @Column(name="DELETE_DATE")
    LocalDateTime deleteDate;

    public User(Long uuid, String nickname, String password, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
        this.deleteDate = deleteDate;
    }
}
