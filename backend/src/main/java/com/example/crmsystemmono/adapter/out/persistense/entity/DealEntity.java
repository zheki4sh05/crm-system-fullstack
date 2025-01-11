package com.example.crmsystemmono.adapter.out.persistense.entity;

import com.example.crmsystemmono.application.domain.model.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deal")
@Builder
public class DealEntity implements IDeal {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private CustomerEntity customer;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "started")
    private Timestamp started;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private UserEntity employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage")
    private StageEntity stage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="source")
    private SourceEntity source;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "deal",fetch = FetchType.LAZY)
    private List<OrderEntity> orderList;

    @OneToMany(mappedBy = "deal",fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;



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

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public List<OrderEntity> getOrderList() {
        return orderList;
    }
}
