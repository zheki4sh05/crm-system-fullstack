package com.example.crmsystemmono.common.security.service;


import com.example.crmsystemmono.adapter.out.persistense.entity.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.*;
import io.jsonwebtoken.security.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import io.jsonwebtoken.Jwts;
import java.security.*;
import java.util.*;
import java.util.function.*;

@Service
public class JwtService {

    @Value("${secret_key}")
    private String SECRET_KEY;
    public String extractUserEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims = extractAllClaims(token);

        return claimResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignInKey()).parseClaimsJws(token).getBody();



    }

    private Key getSignInKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserEntity userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken( Map<String, Object> extraClaims, UserEntity userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.email())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3000 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String email = extractUserEmail(token);
        String emailAuthorities = userDetails.getUsername();
        boolean result = email.equals(emailAuthorities);
        return result && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }


}
