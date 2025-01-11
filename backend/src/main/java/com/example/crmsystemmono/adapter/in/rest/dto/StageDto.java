package com.example.crmsystemmono.adapter.in.rest.dto;

import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StageDto implements IStage {


    private String id;

    @NotNull
    @NotBlank(message = "Stage name must not be blank")
    @Size(min = 1, max = 30, message = "string size: min 1 nad max 30")
    private String name;

    @Size(min = 1, max = 255, message = "string size: min 1 nad max 255")
    private String description;

    @NotNull(message = "Must be a company id")
    private String companyId;

    @NotNull(message = "Must be a group id")
    private String groupId;

    private Integer order;

    public String companyId() {
        return companyId;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setOrder(int i) {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
