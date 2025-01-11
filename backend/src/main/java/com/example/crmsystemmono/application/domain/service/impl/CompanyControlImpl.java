package com.example.crmsystemmono.application.domain.service.impl;
import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.exceptions.*;
import com.example.crmsystemmono.common.mapper.*;

public class CompanyControlImpl implements ICompanyControl {
    private final ICompanyStorage companyStorage;
    private final IRoleStorage roleStorage;
    private final IObjectMapper objectMapper;
    public CompanyControlImpl(ICompanyStorage companyStorage, IRoleStorage roleStorage, IObjectMapper objectMapper) {
        this.companyStorage = companyStorage;
        this.roleStorage = roleStorage;
        this.objectMapper = objectMapper;
    }


    @Override
    public CompanyDto create(ICompany companyDto, IUser user) {
        if(user.getCompany()==null){
            var newCompany = companyStorage.save(companyDto, user);
            createNewRole(user.getId(), newCompany.getId(), Role.ADMIN);
            return objectMapper.mapFrom(newCompany);
        }else{
            throw new SuchEntityAlreadyExists();
        }
    }
    private void createNewRole(String userId,String companyId, Role role){
        roleStorage.save(userId,companyId,role.getValue());
    }

}
