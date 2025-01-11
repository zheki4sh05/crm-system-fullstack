package com.example.crmsystemmono.adapter.out.persistense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@Builder
public class RoleEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "priority")
    private Integer number;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "company")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private UserEntity user;





}
