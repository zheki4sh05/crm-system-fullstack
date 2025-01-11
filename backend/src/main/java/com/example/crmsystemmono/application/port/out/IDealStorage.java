package com.example.crmsystemmono.application.port.out;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;

import java.util.*;

public interface IDealStorage {
    DealEntity create(IDeal dealModel, IUser user);
    IDeal findById(String id);

    DealEntity move(IDeal deal);

    DealEntity save(IDeal deal);

    Optional<ArrayList<DealEntity>> findAllByUserId(String userId);
}
