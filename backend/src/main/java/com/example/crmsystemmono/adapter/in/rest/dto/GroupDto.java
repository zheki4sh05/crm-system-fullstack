package com.example.crmsystemmono.adapter.in.rest.dto;

import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDto implements IGroup {

    private String id;

    @NotNull
    @NotBlank(message = "group name can't be blank")
    @Size(min = 1, max = 30, message = "string size: min 1 nad max 30")
    private String name;

    @Size(min = 1, max = 255, message = "string size: min 1 nad max 255")
    private String description;

    @NotNull
    private String companyId;

    @NotNull
    @Size(min = 3, max = 3, message = "correct length:3")
    private String customerType;

    private Boolean isActive;


    @Override
    public String getCompanyId() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
