package com.example.crmsystemmono.common.security.entity;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import jakarta.persistence.*;
import lombok.*;

/**
 * Сущность, представляющая jwt токен.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String token;


    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker")
    public UserEntity user;
}
