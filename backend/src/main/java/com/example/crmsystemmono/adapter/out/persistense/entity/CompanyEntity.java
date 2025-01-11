package com.example.crmsystemmono.adapter.out.persistense.entity;

import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import org.checkerframework.common.aliasing.qual.*;

import java.sql.*;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
@Builder
public class CompanyEntity implements ICompany {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    @Unique
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "api_key")
    private String api_key;

    @Column(name = "email")
    private String email;



    @Override
    public String getName() {
        return null;
    }
    @Override
    public String getId() {
        return null;
    }
    @Override
    public String getDescription() {
        return null;
    }
}
