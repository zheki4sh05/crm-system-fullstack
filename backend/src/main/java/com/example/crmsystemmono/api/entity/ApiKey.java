package com.example.crmsystemmono.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_key")
@Builder
//public class ApiKey implements UserDetails {
public class ApiKey  implements UserDetails {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "key")
    private String key;

    @Column(name = "company")
    private UUID companyId;


    @Column(name = "valid")
    private Boolean valid;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return companyId.toString();
    }
}
