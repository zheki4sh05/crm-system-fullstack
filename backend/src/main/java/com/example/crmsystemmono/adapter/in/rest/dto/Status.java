package com.example.crmsystemmono.adapter.in.rest.dto;

public enum Status {

    CREATED (1),
    UPDATED (2);

    private Integer status;

    Status(Integer status) {
        this.status = status;
    }

    public Integer value() {
        return status;
    }


}
