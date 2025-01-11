package com.example.crmsystemmono.application.domain.service.impl;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.mapper.*;

public class OrderImpl implements IOrderControl {
    private final IOrderStorage orderStorage;
    private final IObjectMapper objectMapper;

    public OrderImpl(IOrderStorage orderStorage, IObjectMapper objectMapper) {
        this.orderStorage = orderStorage;
        this.objectMapper = objectMapper;
    }

    @Override
    public OrderDto create(IOrder order, IUser user) {
        return objectMapper.mapFrom(orderStorage.create(order,user.getId()));
    }
}
