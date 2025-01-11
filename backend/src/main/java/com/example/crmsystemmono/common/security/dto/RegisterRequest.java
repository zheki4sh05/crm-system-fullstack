package com.example.crmsystemmono.common.security.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String lastname;
    private String name;
    private String email;
    private String password;
}