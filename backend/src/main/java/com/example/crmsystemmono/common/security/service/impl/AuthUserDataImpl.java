package com.example.crmsystemmono.common.security.service.impl;



import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.common.security.dto.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Сервис для получения автооризованных пользователй.
 */
@Service
public class AuthUserDataImpl implements AuthenticatedUserData {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IControlSecurityExpression customSecurityExpression;

    //возвращает пользователя по его адресу электронной почты
    @Override
    public Optional<UserEntity> getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }
    //возвращает адрес электронной почты текущего пользователя.
    @Override
    public String getCurrentUserEmail() {

        return customSecurityExpression.getPrincipal().email();

    }
    //возвращает объект текущего пользователя.
    @Override
    public UserEntity getCurrentUser() {
        return customSecurityExpression.getPrincipal();
    }
    //преобразует объект пользователя в DTO (UserDto), заполняя его поля.
    @Override
    public UserDto mapFrom(UserEntity addUser) {
        return UserDto.builder()
                .name(addUser.getUsername())
                .lastname(addUser.lastname())
                .email(addUser.email())
                .build();
    }
}
