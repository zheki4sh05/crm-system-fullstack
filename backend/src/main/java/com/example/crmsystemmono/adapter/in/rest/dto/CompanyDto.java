package com.example.crmsystemmono.adapter.in.rest.dto;

import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto implements ICompany {

    private String id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    private String apiKey;


    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
