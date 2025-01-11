package com.example.crmsystemmono.adapter.out.persistense.entity;


import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stage")
@Builder
public class StageEntity implements Comparable<StageEntity>, IStage {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Column(name="stage_order")
    private Integer order;

    @Override
    public int compareTo(StageEntity o) {
        return this.order.compareTo(o.order);
    }


    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public void setOrder(int i) {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}