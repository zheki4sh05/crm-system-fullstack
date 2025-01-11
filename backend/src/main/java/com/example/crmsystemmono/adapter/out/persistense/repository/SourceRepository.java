package com.example.crmsystemmono.adapter.out.persistense.repository;


import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface SourceRepository extends JpaRepository<SourceEntity, UUID> {
}
