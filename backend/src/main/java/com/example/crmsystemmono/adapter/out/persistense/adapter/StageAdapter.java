package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class StageAdapter implements IStageStorage {

    @Autowired
    private StageRepository stageRepository;

    @Override
    public StageEntity save(IStage stage) {
        return null;
    }

    @Override
    public Optional<ArrayList<StageEntity>> findAllByCompanyAndGroupId(String id, String companyId) {
        return Optional.empty();
    }

    @Override
    public Optional<StageEntity> findById(String stageId) {
        return stageRepository.findById(UUID.fromString(stageId));
    }
}
