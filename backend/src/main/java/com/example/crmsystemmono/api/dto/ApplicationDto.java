package com.example.crmsystemmono.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDto {

    @NotNull
    @NotBlank
    private String body;

}
