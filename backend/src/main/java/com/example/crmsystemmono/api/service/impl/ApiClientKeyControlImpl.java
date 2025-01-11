package com.example.crmsystemmono.api.service.impl;

import com.example.crmsystemmono.api.entity.*;
import com.example.crmsystemmono.api.repository.*;
import com.example.crmsystemmono.api.security.*;
import com.example.crmsystemmono.api.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ApiClientKeyControlImpl implements IApiClientKeyControl {

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    public String generate(UUID companyId) {

        ApiKey apiKey;

        apiKey = apiKeyRepository.findByCompanyId(companyId).orElse( ApiKey.builder()
                        .key("")
                        .id(UUID.randomUUID())
                .companyId(companyId)
                .valid(true)
                .build());

        String token = apiKeyService.generateToken(apiKey);

        apiKey.setKey(token);

        apiKeyRepository.save(apiKey);

        return token;
    }
}
