package com.example.crmsystemmono.application.port.in;



import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.common.exceptions.*;
import jakarta.persistence.*;

import java.util.*;

public interface IStageControl {
    StageDto create(IStage stageModel, String companyId);

    List<StageDto> fetch(String companyId, String groupId);

    void delete(UUID companyId, UUID groupId, UUID stageId);

    StageDto update(StageDto stageDto);

}
