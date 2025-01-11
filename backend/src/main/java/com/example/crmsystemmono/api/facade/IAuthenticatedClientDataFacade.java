package com.example.crmsystemmono.api.facade;

import com.example.crmsystemmono.api.dto.*;
import com.example.crmsystemmono.api.exceptions.*;
import jakarta.persistence.*;

import java.util.*;

public interface IAuthenticatedClientDataFacade {
    void create(ApplicationDto applicationDto);

    List<ApplicationDto> getAllByApiKey(String apiKey, Long companyId);

//    void addCustomer(CustomerDto customerDto) throws SuchEntityAlreadyExistsException;
//
//    void updateCustomer(CustomerDto customerDto) throws EntityNotFoundException;
}
