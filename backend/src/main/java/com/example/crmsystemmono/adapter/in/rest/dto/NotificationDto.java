package com.example.crmsystemmono.adapter.in.rest.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {

    @NotBlank
    @NotNull
    private String subject;

    @NotBlank
    @NotNull
    @Email(message = "uncorrected email value")
    private String mailTo;

    @NotBlank
    @NotNull
    @Email(message = "uncorrected email value")
    private String mailFrom;

    @NotBlank
    @NotNull
    private String body;

}
