package com.example.crmsystemmono.application.domain.service.impl;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.exceptions.*;
import com.example.crmsystemmono.common.mapper.*;

import jakarta.persistence.*;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

public class StageControlImpl implements IStageControl {
    private final IStageStorage stageStorage;
    private final IObjectMapper objectMapper;

    public StageControlImpl(IStageStorage stageRepository, IObjectMapper objectMapper) {
        this.stageStorage = stageRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public StageDto create(IStage stageModel, String companyId) throws SuchEntityAlreadyExists, EntityNotFoundException, MaxCapacityException {

        var list = new ArrayList<>(
                stageStorage.findAllByCompanyAndGroupId(stageModel.getId(), companyId)
                .orElse(new ArrayList<>()));
        int MAX_COUNT = 10;
        if(list.size()==0){
            stageModel.setOrder(1);
        }else if(list.size()<= MAX_COUNT){
            list.sort(Comparator.comparingInt(IStage::getOrder));
            int order = list.get(list.size()-1).getOrder();
            stageModel.setOrder(order);
        }
        else{
            throw new MaxCapacityException();
        }
        return objectMapper.mapFrom(stageStorage.save(stageModel));
    }

    @Override
    public List<StageDto> fetch(String companyId, String groupId) throws EntityNotFoundException {
        var listWrapper = stageStorage.findAllByCompanyAndGroupId(companyId, groupId);
        if(listWrapper.isPresent()){
            return listWrapper.get().stream()
                    .map(objectMapper::mapFrom)
                    .collect(Collectors.toList());
        }else{
            throw new EntityNotFoundException("Not found");
        }
    }

    @Override
    @Transactional
    public void delete(UUID companyId, UUID groupId, UUID stageId) throws EntityNotFoundException {

//        Stage deleteStage = stageRepository.findByGroupAndCompany(groupId, companyId, stageId).orElseThrow(EntityNotFoundException::new);
//
//
//
//
//        stageRepository.delete(deleteStage);

    }

    @Override
    @Transactional
    public StageDto update(StageDto stageDto) throws SuchEntityAlreadyExists, EntityNotFoundException {

//        Stage updateStage = stageRepository.findByGroupAndCompany( UUID.fromString(stageDto.getGroupId()), UUID.fromString(stageDto.getCompanyId()), UUID.fromString( stageDto.getId())).orElseThrow(EntityExistsException::new);
//        updateStage.setName(stageDto.getName());
//        try {
//            updateStage = stageRepository.save(updateStage);
//        } catch (DataIntegrityViolationException e) {
//            throw new SuchEntityAlreadyExists();
//        }
//
//        return mapFromEntityToDto(updateStage, stageDto.getGroupId().toString());
        return null;
    }
}
