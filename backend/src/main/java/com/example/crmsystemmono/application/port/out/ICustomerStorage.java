package com.example.crmsystemmono.application.port.out;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;

import java.util.*;

public interface ICustomerStorage {
    CustomerEntity save(ICustomer customer);

    Optional<CustomerEntity> findByUuid(UUID id);
}
