package com.example.crmsystemmono.adapter.in.rest.dto;

import lombok.*;

import java.time.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDto {

    private Long id;
    private String name;
    private Boolean isDone;
    private LocalDate start;
    private LocalDate finishAt;
    private String dealId;

}
