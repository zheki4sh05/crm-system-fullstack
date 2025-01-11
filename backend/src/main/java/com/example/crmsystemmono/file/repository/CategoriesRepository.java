package com.example.crmsystemmono.file.repository;


import com.example.crmsystemmono.file.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {

    @Query("""

        select c
        from Category c
        where c.company =:company 

""")
    List<Category> findAllByCompanyId(@Value("company") Long company);


    @Query("""

select c
from Category c
where c.company= :company and c.name= :name

""")
    Category getIfExists(@Param("company") Long id, @Param("name") String name);
}
