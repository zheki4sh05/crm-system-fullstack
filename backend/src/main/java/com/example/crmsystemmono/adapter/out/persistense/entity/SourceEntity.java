package com.example.crmsystemmono.adapter.out.persistense.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "source")
@Builder
public class SourceEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column
    private String name;
}
