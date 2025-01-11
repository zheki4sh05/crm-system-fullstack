//package com.example.crmsystemmono.api.repository;
//
//import com.example.crmsystemmono.api.entity.*;
//import org.springframework.data.jpa.repository.*;
//import org.springframework.data.repository.query.*;
//
//import java.util.*;
//
//public interface ClientRepository extends JpaRepository<Client, Long> {
//
//   @Query("""
//
//select c
//from Customer c
//where c.email= :email
//
//""")
//   Optional<Client> getByEmail(@Param("email") String email);
//}
