package com.example.crmsystemmono.adapter.in.rest.dto;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;
import lombok.*;

import java.util.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealDto implements IDeal {

    private String id;
    private String name;
    private String description;
    private String started;
    private CustomerDto customerDto;
    private List<OrderDto> orderList;
    private String groupId;
    private Integer source;
    private String stageId;
    private String type;
    private UserDto employee;
    private List<TaskDto> tasks;


    @Override
    public ICustomer getCustomer() {
        return null;
    }

    @Override
    public String getGroupId() {
        return null;
    }

    @Override
    public String getStageId() {
        return null;
    }

    @Override
    public String getSourceId() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public IUser getEmployee() {
        return null;
    }

    @Override
    public void moveTo(StageEntity targetStage) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String getStarted() {
        return null;
    }


}
