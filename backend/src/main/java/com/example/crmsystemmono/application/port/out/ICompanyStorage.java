package com.example.crmsystemmono.application.port.out;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;

import java.util.*;

public interface ICompanyStorage {
    CompanyEntity save(ICompany companyDto, IUser user);

    Optional<CompanyEntity> findById(String companyId);
}
