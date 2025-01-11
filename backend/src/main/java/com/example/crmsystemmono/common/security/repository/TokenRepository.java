package com.example.crmsystemmono.common.security.repository;


import com.example.crmsystemmono.common.security.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {
    @Query(value = """
      select t from Token t inner join UserEntity u
      on t.user.id = u.id
      where u.id = :id and (t.expired = false or t.revoked = false)
      """)
    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);
}
