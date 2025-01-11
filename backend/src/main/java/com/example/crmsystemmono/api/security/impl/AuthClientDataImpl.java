package com.example.crmsystemmono.api.security.impl;

import com.example.crmsystemmono.api.entity.*;
import com.example.crmsystemmono.api.repository.*;
import com.example.crmsystemmono.api.security.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class AuthClientDataImpl implements IAuthClientData {


        @Autowired
        private ApiKeyRepository apiKeyRepository;

        @Autowired
        private IControlSecurityExpression customSecurityExpression;

        //возвращает пользователя по его адресу электронной почты

        @Override
        public ApiKey getCurrentUser() {
            return customSecurityExpression.getPrincipal();
        }
        //преобразует объект пользователя в DTO (UserDto), заполняя его поля.


}
