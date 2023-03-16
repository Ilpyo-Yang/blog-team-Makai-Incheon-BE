package com.bms.blog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long uuid;
    private String nickname;
    private String password;

    public UserDto(Long uuid, String nickname, String password){
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
    }
}
