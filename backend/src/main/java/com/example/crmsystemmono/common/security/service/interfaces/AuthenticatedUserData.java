package com.example.crmsystemmono.common.security.service.interfaces;


import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.common.security.dto.*;

import java.util.*;

public interface AuthenticatedUserData {

    Optional<UserEntity> getUserByEmail(String email);

    String getCurrentUserEmail();

    UserEntity getCurrentUser();

    UserDto mapFrom(UserEntity addUser);
}
