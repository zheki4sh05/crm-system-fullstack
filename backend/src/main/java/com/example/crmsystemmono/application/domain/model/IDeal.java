package com.example.crmsystemmono.application.domain.model;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;

import java.util.stream.*;

public interface IDeal {
    ICustomer getCustomer();

    String getGroupId();

    String getStageId();

    String getSourceId();

    String getDescription();

    String getId();

    IUser getEmployee();

    void moveTo(StageEntity targetStage);

    String getName();

    void setName(String name);

    void setDescription(String description);

    String getStarted();


}
