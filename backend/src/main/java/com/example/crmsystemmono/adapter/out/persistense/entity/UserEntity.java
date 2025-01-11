package com.example.crmsystemmono.adapter.out.persistense.entity;

import com.example.crmsystemmono.application.domain.model.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;


import java.time.*;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker")
@Builder
public class UserEntity implements UserDetails, IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    public String lastname() {
        return lastname;
    }

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    public String email() {
        return email;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "surname")
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<RoleEntity> roles=new ArrayList<>();

    public UserEntity(Long id, String firstname, String lastname, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(email));
    }

    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public String getUsername() {
        return email;
    }


//    public Integer getRolePriority() {
//        return this.role.getNumber();
//
//    }

    @Override
    public ICompany getCompany() {
        return roles.get(0).getCompany();
    }

    @Override
    public String getId() {
        return null;
    }

    public List<Role> getRoles() {
        var rolesDto = new ArrayList<Role>();
        roles.forEach(item->{
            if(item.getNumber().equals(Role.ADMIN.getValue())){
                rolesDto.add(Role.ADMIN);
            }else{
                rolesDto.add(Role.USER);
            }
        });
        return rolesDto;

    }
}
