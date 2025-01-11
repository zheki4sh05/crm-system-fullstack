package com.example.crmsystemmono.application.port.out;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;

import java.util.*;

public interface IStageStorage {

    StageEntity save(IStage stage);

    Optional<ArrayList<StageEntity>> findAllByCompanyAndGroupId(String id, String companyId);

    Optional<StageEntity> findById(String stageId);
}
 