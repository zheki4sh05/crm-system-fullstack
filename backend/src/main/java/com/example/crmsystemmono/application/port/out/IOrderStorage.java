package com.example.crmsystemmono.application.port.out;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;

public interface IOrderStorage {
    OrderEntity create(IOrder dto ,String userId);
}
