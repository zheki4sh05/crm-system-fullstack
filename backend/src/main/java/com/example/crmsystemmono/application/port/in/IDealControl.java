package com.example.crmsystemmono.application.port.in;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;

import java.util.*;

public interface IDealControl {
    DealDto createDealByUserId(IDeal dealModel, IUser userModel);

    DealDto update(IDeal dealDto, String userId);

    List<DealDto> fetchByUser(String userId);

    DealDto move(DealDto dealDto, String companyId);
}
