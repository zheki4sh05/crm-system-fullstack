package com.example.crmsystemmono;


import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.Role;
import com.example.crmsystemmono.common.security.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.configuration.*;


import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

@SpringBootApplication
public class CrmSystemMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmSystemMonoApplication.class, args);
	}

	@Autowired
	private UserRepository repository;

	@Bean
	public UserDetailsService userDetailsService(){

		return (email) -> {

		UserEntity user =  repository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
//			if(Objects.equals(user.getRolePriority(), Role.ADMIN.getValue())){
//				return new UserRole(Role.ADMIN,user);
//			}else{
//				return new UserRole(Role.USER,user);
//			}
			return new UserRole(user.getRoles(), user);

		};
	}

	@Bean
	public AuthenticationProvider authenticationProvider(){

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

		authenticationProvider.setUserDetailsService(userDetailsService());

		authenticationProvider.setPasswordEncoder(passwordEncoder());

		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
