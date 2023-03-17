package com.bms.blog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private Long uuid;
    private String nickname;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime editDate;
    private LocalDateTime deleteDate;

    public UserDto(Long uuid, String nickname, String password,
                   LocalDateTime createdDate, LocalDateTime editDate, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
        this.createdDate = createdDate;
        this.editDate = editDate;
        this.deleteDate = deleteDate;
    }
}
