package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.time.*;
import java.util.*;

@Component
public class CompanyAdapter implements ICompanyStorage {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyEntity save(ICompany companyDto, IUser user) {
        var companyEntity = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .name(companyDto.getName())
                .description(companyDto.getDescription())
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        return companyRepository.save(companyEntity);
    }

    @Override
    public Optional<CompanyEntity> findById(String companyId) {
        return companyRepository.findById(UUID.fromString(companyId));
    }
}
