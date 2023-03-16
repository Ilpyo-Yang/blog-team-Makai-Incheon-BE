package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public User(Long uuid, String nickname, String password){
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
    }
}
