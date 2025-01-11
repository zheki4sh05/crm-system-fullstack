package com.example.crmsystemmono.application.domain.model;

public interface IOrder {
    String getDealId();

    String getCode();

    Integer getCount();

    Double getPrice();

    String getName();
}
