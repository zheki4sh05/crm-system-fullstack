package com.example.crmsystemmono.application.port.in;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;

public interface IOrderControl {
    OrderDto create(IOrder dto, IUser user);
}
