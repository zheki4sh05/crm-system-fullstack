package com.example.crmsystemmono.common.security.entity;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;

import java.util.*;
import java.util.stream.*;

/**
 * Dto пользовательских ролей в системе.
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends UserEntity {

    private List<Role> roleDto;

    public UserRole(List<Role> roleDto, UserEntity user) {
        super(Long.valueOf(user.getId()), user.getUsername(), user.lastname(), user.email(),user.getPassword());
        this.roleDto = roleDto;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleDto.stream().map(item->new SimpleGrantedAuthority(item.name())).collect(Collectors.toList());

    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }


}
