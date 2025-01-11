package com.example.crmsystemmono.common.security.service.impl;


import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.common.security.service.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service("cse")
@RequiredArgsConstructor
public class CustomSecurityExpressionImpl implements IControlSecurityExpression {

    private final JwtService jwtService;

    public boolean canAccessUser(Map<String, String> headers) {

        UserEntity user = getPrincipal();

        Boolean isAccessed = getUserEmail(headers).equals(user.email());


        return isAccessed;
    }
    public UserEntity getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return (UserEntity) authentication.getPrincipal();
    }
    public String getUserEmail(Map<String, String> headers){
        return jwtService.extractUserEmail(headers.get("authorization").split(" ")[1]);
    }

}

