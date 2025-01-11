package com.example.crmsystemmono.adapter.out.persistense.repository;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
}
