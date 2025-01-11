package com.example.crmsystemmono.application.port.in;
import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.domain.model.*;
import java.util.*;

public interface IGroupControl{
        GroupDto create(IGroup groupDto, IUser user);

        List<GroupDto> fetch(String companyId);

        void delete(UUID companyId, UUID groupId);

        GroupDto update(IGroup groupDto, ICompany company);
}
