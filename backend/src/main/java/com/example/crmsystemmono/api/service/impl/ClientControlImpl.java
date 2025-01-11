//package com.example.crmsystemmono.api.service.impl;
//
//import com.example.crmsystemmono.api.dto.*;
//import com.example.crmsystemmono.api.entity.*;
//import com.example.crmsystemmono.api.exceptions.*;
//import com.example.crmsystemmono.api.repository.*;
//import com.example.crmsystemmono.api.service.*;
//import jakarta.persistence.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.stereotype.*;
//
//@Service
//public class ClientControlImpl implements IClientControl {
//
//    @Autowired
//    private ClientRepository customerRepository;
//
//    @Override
//    public void add(ApiKey apiKey, CustomerDto customerDto) throws SuchEntityAlreadyExistsException {
//
//
//
//        if(customerRepository.getByEmail(customerDto.getEmail()).isEmpty()){
//            Client customer = Client.builder()
//                    .body(customerDto.getBody())
//                    .status(Status.CREATED.value())
//                    .key(apiKey)
//                    .email(customerDto.getEmail())
//                    .phone(customerDto.getPhone())
//                    .build();
//
//            customerRepository.save(customer);
//        }else{
//            throw new SuchEntityAlreadyExistsException("customer with such already exists");
//        }
//
//
//
//    }
//    @Override
//    public void update(ApiKey apiKey, CustomerDto customerDto) throws EntityNotFoundException {
//
//        Client customer =  customerRepository.getByEmail(customerDto.getEmail()).orElseThrow(EntityNotFoundException::new);
//
//        customer.setPhone(customerDto.getPhone());
//        customer.setEmail(customerDto.getEmail());
//        customer.setBody(customerDto.getBody());
//        customer.setStatus(Status.UPDATED.value());
//
//        customerRepository.save(customer);
//
//    }
//}
