package com.example.crmsystemmono.adapter.out.persistense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
@Builder
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deal")
    private DealEntity deal;

    @Column(name = "is_done")
    private Boolean is_done;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "worker")
    private UserEntity worker;

    @Column(name = "start")
    private Timestamp start;

    @Column(name = "finish_at")
    private Timestamp finishAt;




}
