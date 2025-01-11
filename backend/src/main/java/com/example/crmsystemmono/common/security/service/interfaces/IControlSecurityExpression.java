package com.example.crmsystemmono.common.security.service.interfaces;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;

import java.util.*;

public interface IControlSecurityExpression {

    UserEntity getPrincipal();
    boolean canAccessUser(Map<String, String> headers);
    String getUserEmail(Map<String, String> headers);

}
