package com.example.crmsystemmono.application.domain.service.impl;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

//@Service
//public class CustomerControlImpl implements ICustomerControl {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private Customer saveEntity(Customer entity){
//        return customerRepository.save(entity);
//    }
//    @Override
//    public Customer findOrCreate(CustomerDto dto, Company id) {
//
//        return customerRepository.findByEmail(dto.getEmail()).orElse(
//                saveEntity(
//                        Customer.builder()
//                                .id(UUID.randomUUID())
//                        .email(dto.getEmail())
//                        .name(dto.getName())
//                        .lastname(dto.getLastname())
//                        .address(dto.getAddress())
//                                .company(id)
//                                .build()));
//
//    }
//}
