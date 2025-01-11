package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.security.repository.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class RoleAdapter implements IRoleStorage {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(String userId, String companyId, Integer value) {
        var role = RoleEntity.builder()
                .id(UUID.randomUUID())
                .number(value)
                .company(companyRepository.findById(UUID.fromString(companyId)).orElseThrow(()->new EntityNotFoundException("Company not found")))
                .user(userRepository.findById(UUID.fromString(userId)).orElseThrow(()->new EntityNotFoundException("User not found")))
                .build();
        roleRepository.save(role);

    }
}
