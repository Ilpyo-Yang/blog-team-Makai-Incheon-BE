package com.bms.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Id
    @Column(name="UUID")
    private String uuid = UUID.randomUUID().toString();

    @Column(name="NICKNAME", updatable = false, unique = true, nullable = false)
    private String nickname;

    @Column(name="Password", nullable = false)
    private String password;

    @Column(name="DELETE_DATE")
    LocalDateTime deleteDate;

    @Column(name="ROLE", columnDefinition = "varchar(100) default 'ROLE_USER'")
    private String role;

    public User(String uuid, String nickname, String password, String role, LocalDateTime deleteDate){
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
        this.deleteDate = deleteDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(role));
        return list;
    }

    @Override
    public String getUsername() {
        return uuid;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
