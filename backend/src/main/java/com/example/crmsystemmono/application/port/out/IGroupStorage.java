package com.example.crmsystemmono.application.port.out;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;

import java.util.*;

public interface IGroupStorage {
    Optional<GroupEntity> findByCompanyIdAndGroup(String companyId, String groupName);

    GroupEntity create(IGroup group, String companyId);

    Optional<List<GroupEntity>> findByCompanyId(String companyId);

    GroupEntity save(IGroup groupDto, ICompany company);
}
