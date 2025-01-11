package com.example.crmsystemmono.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotBlank
    @NotNull
    private String body;

    private String email;
    private String phone;

}
