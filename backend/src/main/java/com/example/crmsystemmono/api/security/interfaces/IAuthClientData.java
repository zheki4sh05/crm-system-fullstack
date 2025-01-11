package com.example.crmsystemmono.api.security.interfaces;

import com.example.crmsystemmono.api.entity.*;

public interface IAuthClientData {

//    Optional<User> getUserByEmail(String email);
//
//    String getCurrentUserEmail();

    ApiKey getCurrentUser();

//    UserDto mapFrom(User addUser);
}

