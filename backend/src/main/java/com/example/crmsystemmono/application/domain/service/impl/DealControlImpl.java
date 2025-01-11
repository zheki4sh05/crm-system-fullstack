package com.example.crmsystemmono.application.domain.service.impl;
import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.mapper.*;
import jakarta.persistence.*;
import java.util.*;
import java.util.stream.*;

public class DealControlImpl implements IDealControl {

    private final IDealStorage dealRepository;
    private final IStageStorage stageStorage;
    private final IObjectMapper objectMapper;

    public DealControlImpl(IDealStorage dealRepository, IStageStorage stageStorage, IObjectMapper objectMapper) {
        this.dealRepository = dealRepository;
        this.stageStorage = stageStorage;
        this.objectMapper = objectMapper;
    }

    @Override
    public DealDto createDealByUserId(IDeal dealModel, IUser user) {

        var stages = stageStorage.findAllByCompanyAndGroupId(user.getCompany().getId(), dealModel.getGroupId());
        if(stages.isPresent()){
            return objectMapper.mapFrom(dealRepository.create(dealModel, user));
        }else {
            throw new EntityNotFoundException("Stages not found");
        }
    }

    @Override
    public DealDto update(IDeal dealDto, String userId) throws EntityNotFoundException {

        var deal = dealRepository.findById(dealDto.getId());
        if(deal.getEmployee().getId().equals(userId)){
            deal.setName(dealDto.getName());
            deal.setDescription(dealDto.getDescription());
            return objectMapper.mapFrom(dealRepository.save(deal));
        }else{
            throw new EntityNotFoundException("Deal for that user not found");
        }
    }


    @Override
    public List<DealDto> fetchByUser(String userId) {
          return dealRepository.findAllByUserId(userId)
                  .map(list->list.stream().map(objectMapper::mapFrom).collect(Collectors.toList()))
                  .orElse(Collections.emptyList());
    }

    @Override
    public DealDto move(DealDto dealDto, String companyId) {
        var stages = stageStorage.findAllByCompanyAndGroupId(companyId, dealDto.getGroupId());
        if(stages.isPresent()){
            var targetStage = stages.get()
                    .stream()
                    .filter(item->item.getId().equals(dealDto.getStageId()))
                    .findFirst()
                    .orElseThrow(()->new EntityNotFoundException("Stage not found"));
            var deal = dealRepository.findById(dealDto.getId());
            if(dealDto.getEmployee().getId().equals(deal.getEmployee().getId())){
                deal.moveTo(targetStage);
                return objectMapper.mapFrom(dealRepository.move(deal));
            }else{
                throw new EntityNotFoundException("Deal not found");
            }
        }else {
            throw new EntityNotFoundException("Stages not found");
        }
    }

}
