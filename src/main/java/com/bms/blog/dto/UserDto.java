package com.bms.blog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private String uuid;
    private String nickname;
    private String password;
    private String role;
    private LocalDateTime createdDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public UserDto(String uuid, String nickname, String password, String role,
                   LocalDateTime createdDate, LocalDateTime editDate, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
        this.createdDate = createdDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
}
