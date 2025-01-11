package com.example.crmsystemmono.api.service;

import com.example.crmsystemmono.api.dto.*;
import com.example.crmsystemmono.api.entity.*;

import java.util.*;

public interface IApplicationControl {
    void create(ApplicationDto applicationDto, ApiKey apiKeyEntity);

    String generate(Long companyId);

    List<ApplicationDto> getAllByApiKeyAndCompanyId(ApiKey apikeyEntity, Long companyId);
}
