//package com.example.crmsystemmono.api.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "client")
//@Builder
//public class Client {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "body")
//    private String body;
//
//    @Column(name = "status")
//    private Integer status;
//
//    @ManyToOne
//    @ToString.Exclude
//    @JoinColumn(name = "key")
//    private ApiKey key;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "phone")
//    private String phone;
//
//}
