package com.example.crmsystemmono.application.domain.service.impl;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.exceptions.*;
import com.example.crmsystemmono.common.mapper.*;

import jakarta.persistence.*;
import org.springframework.dao.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

public class GroupControlImpl implements IGroupControl {

    private final IGroupStorage storage;
    private final IObjectMapper objectMapper;

    public GroupControlImpl(IGroupStorage storage, IObjectMapper objectMapper) {
        this.storage = storage;
        this.objectMapper = objectMapper;
    }

    @Override
    public GroupDto create(IGroup group, IUser domain) {
        if(storage.findByCompanyIdAndGroup(group.getId(), group.getName()).isEmpty()){
            return objectMapper.mapFrom(storage.create(group,domain.getCompany().getId()));
        }else{
            throw new SuchEntityAlreadyExists("Group with name '"+group.getName()+"' already exists!");
        }
    }

    @Override
    public List<GroupDto> fetch(String companyId) {
        return  storage.findByCompanyId(companyId)
                .map(list->list.stream().map(objectMapper::mapFrom).collect(Collectors.toList()))
                .orElse(new ArrayList<>());

    }

    @Override
    public void delete(UUID companyId, UUID groupId) {
//        Group deleteGroup = groupRepository.findByCompanyIdAndGroup(companyId, groupId).orElseThrow(EntityNotFoundException::new);
//
//        groupRepository.delete(deleteGroup);
    }

    @Override
    public GroupDto update(IGroup groupDto, ICompany company) {
        try{
            return objectMapper.mapFrom(storage.save(groupDto, company));
        }catch (DataIntegrityViolationException e){
            throw new SuchEntityAlreadyExists("Group with name '"+groupDto.getName()+"' already exists!");
        }
    }
}
