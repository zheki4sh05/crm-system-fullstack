package com.example.crmsystemmono.adapter.in.rest.dto;

import com.example.crmsystemmono.application.domain.model.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto implements IUser {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    private String role;

    @Override
    public ICompany getCompany() {
        return null;
    }
}
