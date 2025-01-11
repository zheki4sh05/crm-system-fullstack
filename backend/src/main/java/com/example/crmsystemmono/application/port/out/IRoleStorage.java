package com.example.crmsystemmono.application.port.out;

public interface IRoleStorage {
    void save(String userId, String companyId, Integer value);
}
