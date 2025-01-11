package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class DealAdapter implements IDealStorage {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private ICustomerStorage customerStorage;


    @Override
    public DealEntity create(IDeal dealModel, IUser userModel) {
        var customer = customerStorage.findByUuid(dealModel.getCustomer().getId())
                .or(()-> Optional.of(customerStorage.save(dealModel.getCustomer()))).get();

        var user = userRepository.findById(UUID.fromString(userModel.getId()))
                .orElseThrow(()->new EntityNotFoundException("Пользователь с таким логином не найден"));

        var group = groupRepository.findByUUid(UUID.fromString(dealModel.getGroupId()))
                .orElseThrow(()->new EntityNotFoundException("Группа не найдена"));

        var stage = stageRepository.findById(UUID.fromString(dealModel.getStageId()))
                .orElseThrow(()->new EntityNotFoundException("Стадия не найдена"));

        var source = sourceRepository.findById(UUID.fromString(dealModel.getSourceId()))
                .orElseThrow(()->new EntityNotFoundException("Источник не найден"));

        return dealRepository.save(DealEntity.builder()
                .id(UUID.randomUUID())
                .customer(customer)
                .employee(user)
                .description(dealModel.getDescription())
                .group(group)
                .stage(stage)
                .source(source)
                .build());
    }

    @Override
    public IDeal findById(String id) {
        var deal = dealRepository.findById(Long.parseLong(id));
        if(deal.isPresent()){
            return deal.get();
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public DealEntity move(IDeal dealModel) {
        var entity = (DealEntity) dealModel;
        return dealRepository.save(entity);
    }

    @Override
    public DealEntity save(IDeal deal) {
        var entity = (DealEntity) deal;
        return dealRepository.save(entity);
    }

    @Override
    public Optional<ArrayList<DealEntity>> findAllByUserId(String userId) {
        return Optional.empty();
    }
}
