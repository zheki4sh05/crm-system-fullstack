package com.example.crmsystemmono.adapter.out.persistense.repository;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("""

select u 
from UserEntity u 
where u.email=:email

""")
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
