package com.example.crmsystemmono.application.domain.model;

public enum Role {
    ADMIN (1),
    USER (2);

    private Integer value;

    Role(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
