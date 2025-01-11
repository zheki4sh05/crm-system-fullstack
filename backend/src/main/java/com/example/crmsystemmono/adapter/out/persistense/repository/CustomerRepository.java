package com.example.crmsystemmono.adapter.out.persistense.repository;


import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.application.domain.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("""

select c 
from CustomerEntity c 
where c.email= :email

""")
    Optional<CustomerEntity> findByEmail(@Value("email") String email);


    @Query("""

select c 
from CustomerEntity c 
where c.id= :id

""")
    Optional<CustomerEntity> findByUuid(@Value("id")UUID id);
}
