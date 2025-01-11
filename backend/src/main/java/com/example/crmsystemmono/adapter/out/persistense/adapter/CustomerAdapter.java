package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class CustomerAdapter implements ICustomerStorage {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(ICustomer customer) {
        return null;
    }

    @Override
    public Optional<CustomerEntity> findByUuid(UUID id) {
        return customerRepository.findByUuid(id);
    }
}
