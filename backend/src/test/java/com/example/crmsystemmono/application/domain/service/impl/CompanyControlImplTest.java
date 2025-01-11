package com.example.crmsystemmono.application.domain.service.impl;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.exceptions.*;
import com.example.crmsystemmono.common.mapper.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyControlImplTest {

    @Mock
    private ICompanyStorage companyStorage;

    @Mock
    private IRoleStorage roleStorage;
    @Mock
    private IObjectMapper objectMapper;

    @InjectMocks
    private CompanyControlImpl companyControl;

    @Test
    void create_new_company(){

            var company = CompanyDto.builder()
                    .name("Новая компания")
                    .build();

            var companyEntity = CompanyEntity.builder().id(UUID.randomUUID()).name("Новая компания").build();

            var user = UserDto.builder().id(String.valueOf(UUID.randomUUID())).build();
            when(companyStorage.save(company, user)).thenReturn(companyEntity);
            doNothing().when(roleStorage).save(user.getId(), companyEntity.getId(), Role.ADMIN.getValue());
            when(objectMapper.mapFrom(companyEntity)).thenReturn(company);

             assertDoesNotThrow(()->
                    {
                        companyControl.create(company, user);
                    }
            );
    }

    @Test
    void create_new_company_throw_exception(){

        var company = CompanyDto.builder()
                .name("Новая компания")
                .build();

        var companyEntity = CompanyEntity.builder().id(UUID.randomUUID()).name("Новая компания").build();
        var userEntity = UserEntity.builder()
                .id(1l)
                .roles(List.of(RoleEntity
                        .builder()
                                .user(null)
                                .number(Role.ADMIN.getValue())
                                .company(companyEntity)
                        .build())
        )
                .build();

       verify(companyStorage, times(0)).save(company, userEntity);
        var exception = assertThrows(SuchEntityAlreadyExists.class, ()->{  companyControl.create(company,userEntity);});

    }

}