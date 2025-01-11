package com.example.crmsystemmono.adapter.out.persistense.repository;


import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    @Query("""
    select g 
    from GroupEntity g 
    where g.company.id = :companyId and g.id= :groupName
    
    """)
    Optional<GroupEntity> findByCompanyIdAndGroupName(@Param("companyId")UUID companyId, @Param("groupName") String name);

    @Query("""
    select g 
    from GroupEntity g 
    where g.id= :uuid
    
    """)
    Optional<GroupEntity> findByUUid(@Param("uuid")UUID uuid);

    @Query("""

select ge 
from GroupEntity ge 
where ge.company.id= :companyId

""")
    Optional<List<GroupEntity>> findByCompanyId(@Param("companyId")String companyId);
}
