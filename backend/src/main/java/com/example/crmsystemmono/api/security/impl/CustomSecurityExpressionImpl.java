package com.example.crmsystemmono.api.security.impl;

import com.example.crmsystemmono.api.entity.*;
import com.example.crmsystemmono.api.security.*;
import com.example.crmsystemmono.api.security.interfaces.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;

@Service("cse2")
@RequiredArgsConstructor
public class CustomSecurityExpressionImpl implements IControlSecurityExpression {

    @Autowired
    private ApiKeyService jwtService;
    public ApiKey getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return (ApiKey) authentication.getPrincipal();
    }

}
