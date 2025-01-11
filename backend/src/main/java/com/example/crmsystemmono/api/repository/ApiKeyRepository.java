package com.example.crmsystemmono.api.repository;

import com.example.crmsystemmono.api.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Long> {

    @Query("""
        
        select ak 
        from ApiKey ak 
        where ak.key= :key

""")
    Optional<ApiKey> findByKey(@Param("key") String key);


    @Query("""

select ak 
from ApiKey ak 
where ak.companyId= :companyId

""")
    Optional<ApiKey> findByCompanyId(@Param("companyId") UUID companyId);
}
