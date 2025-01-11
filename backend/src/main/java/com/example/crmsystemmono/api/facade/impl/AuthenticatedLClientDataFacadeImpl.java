package com.example.crmsystemmono.api.facade.impl;

import com.example.crmsystemmono.api.dto.*;
import com.example.crmsystemmono.api.entity.*;
import com.example.crmsystemmono.api.exceptions.*;
import com.example.crmsystemmono.api.facade.*;
import com.example.crmsystemmono.api.repository.*;
import com.example.crmsystemmono.api.security.interfaces.*;
import com.example.crmsystemmono.api.service.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class AuthenticatedLClientDataFacadeImpl implements IAuthenticatedClientDataFacade {

    @Autowired
    private IAuthClientData authenticatedClientData;

    @Autowired
    private IApplicationControl applicationControl;

    @Autowired
    private ApiKeyRepository apiKeyRepository;

//    @Autowired
//    private IClientControl customerControl;

    private ApiKey getAuthenticatedClientEntity(){
        ApiKey apiKey = authenticatedClientData.getCurrentUser();

        return apiKeyRepository.findByKey(apiKey.getKey()).get();
    }

    @Override
    public void create(ApplicationDto applicationDto) {

        applicationControl.create(applicationDto, getAuthenticatedClientEntity());


    }

    @Override
    public List<ApplicationDto> getAllByApiKey(String apiKey, Long companyId) throws EntityNotFoundException {

        ApiKey apikeyEntity = apiKeyRepository.findByKey(apiKey).orElseThrow(EntityExistsException::new);


        return applicationControl.getAllByApiKeyAndCompanyId(apikeyEntity,companyId);
    }

//    @Override
//    public void addCustomer(CustomerDto customerDto)  throws SuchEntityAlreadyExistsException {
//
//        ApiKey apiKey = getAuthenticatedClientEntity();
//
//        customerControl.add(apiKey, customerDto);
//
//    }
//    @Override
//    public void updateCustomer(CustomerDto customerDto) {
//
//        ApiKey apiKey = getAuthenticatedClientEntity();
//
//        customerControl.update(apiKey, customerDto);
//
//    }
}
