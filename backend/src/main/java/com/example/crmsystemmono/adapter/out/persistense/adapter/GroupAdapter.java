package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class GroupAdapter implements IGroupStorage {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private ICompanyStorage companyStorage;

    @Override
    public Optional<GroupEntity> findByCompanyIdAndGroup(String companyId, String groupName) {

        return groupRepository.findByCompanyIdAndGroupName(
                UUID.fromString(companyId),
                groupName
                );
    }

    @Override
    public GroupEntity create(IGroup group, String companyId) {
        var newGroup = GroupEntity.builder()
                .id(UUID.randomUUID())
                .name(group.getName())
                .company(companyStorage.findById(companyId)
                        .orElseThrow(()->new EntityNotFoundException("Company not found!")))
                .description(group.getDescription())
                .build();
        groupRepository.save(newGroup);
        return newGroup;
    }

    @Override
    public Optional<List<GroupEntity>> findByCompanyId(String companyId) {
        return groupRepository.findByCompanyId(companyId);
    }

    @Override
    public GroupEntity save(IGroup groupDto, ICompany company) {
        var companyEntity = (CompanyEntity)company;
        var groupEntity = GroupEntity.builder()
                .id(UUID.fromString(groupDto.getId()))
                .name(groupDto.getName())
                .description(groupDto.getDescription())
                .company(companyEntity)
                .build();

        return groupRepository.save(groupEntity);
    }
}
