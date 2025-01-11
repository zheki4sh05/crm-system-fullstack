package com.example.crmsystemmono.common.mapper.impl;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.api.entity.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.common.mapper.*;



import org.springframework.stereotype.*;

import java.time.*;
import java.util.stream.*;

@Component
public class IObjectMapperImpl implements IObjectMapper {


    @Override
    public DealDto mapFrom(DealEntity save) {
        return DealDto.builder()
                .id(save.getId())
                .name(save.getName())
                .customerDto(mapFrom((CustomerEntity)save.getCustomer()))
                .description(save.getDescription())
                .stageId(save.getStageId())
                .groupId(save.getGroupId())
//                .source(save.getSourceId())
                .started(save.getStarted())
                .tasks(save.getTasks().stream()
                        .map(this::mapFrom)
                        .collect(Collectors.toList()))
                .orderList(save.getOrderList().stream()
                        .map(this::mapFrom)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public CustomerDto mapFrom(CustomerEntity customer) {

        return CustomerDto.builder()
                .id(customer.getId().toString())
                .name(customer.getName())
                .phone(customer.getPhone())
                .lastname(customer.getLastname())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public CompanyDto mapFrom(CompanyEntity companyEntity) {
        return CompanyDto.builder()
                .id(companyEntity.getId())
                .apiKey("")
                .description(companyEntity.getDescription())
                .name(companyEntity.getName())
                .build();
    }

    @Override
    public TaskDto mapFrom(TaskEntity task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .start(task.getStart().toLocalDateTime().toLocalDate())
                .dealId(task.getDeal().getId())
                .isDone(task.getIs_done())
                .build();
    }

    @Override
    public OrderDto mapFrom(OrderEntity newOrder) {
        return null;
    }

    @Override
    public GroupDto mapFrom(GroupEntity groupEntity) {
        return null;
    }

    @Override
    public StageDto mapFrom(StageEntity save) {
        return null;
    }
}
