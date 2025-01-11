package com.example.crmsystemmono.common.mapper;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.api.entity.*;
import com.example.crmsystemmono.application.domain.model.*;



public interface IObjectMapper {
    DealDto mapFrom(DealEntity save);

    CustomerDto mapFrom(CustomerEntity customer);
    CompanyDto mapFrom(CompanyEntity companyEntity);

    TaskDto mapFrom(TaskEntity task);

    OrderDto mapFrom(OrderEntity newOrder);

    GroupDto mapFrom(GroupEntity groupEntity);
    StageDto mapFrom(StageEntity save);

}
