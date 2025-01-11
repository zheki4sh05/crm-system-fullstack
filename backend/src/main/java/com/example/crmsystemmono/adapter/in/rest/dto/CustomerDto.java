package com.example.crmsystemmono.adapter.in.rest.dto;

import com.example.crmsystemmono.application.domain.model.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto implements ICustomer {

    private String id;
    @NotBlank
    @NotNull
    private String body;
    private String name;
    private String lastname;
    private String address;
    private String email;
    private String phone;

    @Override
    public UUID getId() {
        return null;
    }
}
