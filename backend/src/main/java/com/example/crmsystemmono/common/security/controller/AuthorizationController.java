package com.example.crmsystemmono.common.security.controller;

import com.example.crmsystemmono.common.exceptions.*;
import com.example.crmsystemmono.common.security.dto.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthorizationController {

    @Autowired
    private IAuthenticationService service; //сервис для управления аутентификацией и авторизацией пользователей

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request){


            return ResponseEntity.ok(service.register(request));


    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
