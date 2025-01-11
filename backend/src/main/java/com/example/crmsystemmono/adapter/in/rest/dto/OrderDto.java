package com.example.crmsystemmono.adapter.in.rest.dto;


import com.example.crmsystemmono.application.domain.model.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto implements IOrder {
    private String id;
    private String name;
    private Integer count;
    private Double price;
    private String dealId;
    private String code;

    @Override
    public String getDealId() {
        return null;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public Integer getCount() {
        return null;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
