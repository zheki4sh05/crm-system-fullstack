package com.example.crmsystemmono.adapter.out.persistense.entity;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Builder
public class CustomerEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "company")
    private CompanyEntity company;

}
