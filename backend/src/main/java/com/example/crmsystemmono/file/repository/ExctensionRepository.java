package com.example.crmsystemmono.file.repository;


import com.example.crmsystemmono.file.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ExctensionRepository extends JpaRepository<Extension, Long> {
    Optional<Extension> findByName(String s);
}
