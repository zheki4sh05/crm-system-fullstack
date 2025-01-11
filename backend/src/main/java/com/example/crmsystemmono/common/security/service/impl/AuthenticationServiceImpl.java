package com.example.crmsystemmono.common.security.service.impl;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.common.exceptions.*;
import com.example.crmsystemmono.common.security.dto.*;
import com.example.crmsystemmono.common.security.entity.*;
import com.example.crmsystemmono.common.security.repository.*;
import com.example.crmsystemmono.common.security.service.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Сервис для управления авторизацией и аутентификацией пользователей.
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  TokenRepository tokenRepository;

    @Autowired
    private  IControlSecurityExpression customSecurityExpression;

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Регистрирует нового пользователя.
     *
     * @param request Запрос на регистрацию.
     * @return Ответ с JWT-токеном для аутентификации.
     * @throws UserWithSuchEmailAlreadyExistsException Если пользователь с такой почтой уже существует.
     */
    @Override
    public AuthenticationResponse register(RegisterRequest request)throws UserWithSuchEmailAlreadyExistsException {
        Optional<UserEntity> userOptional = repository.findByEmail(request.getEmail());
        if(userOptional.isEmpty()){

            var user  = UserEntity.builder()
                    .firstname(request.getName())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
//                    .role(roleRepository.getWithPriority(Role.USER.getValue()))
                    .build();


            // Сохраняем пользователя в репозитории
            repository.save(user);
            // Генерируем JWT-токен для аутентификации
//            var jwtToken = jwtService.generateToken(user);

            // Сохраняем токен пользователя
//            saveUserToken(savedUser, jwtToken);
            // Возвращаем ответ с токено
            return AuthenticationResponse.builder()
                    .token("")
                    .build();
        }else{
            // Если пользователь с такой почтой уже существует, выбрасываем исключение
            throw new UserWithSuchEmailAlreadyExistsException();
        }

    }
    /**
     * Сохраняет токен пользователя.
     *
     * @param user      Пользователь, для которого сохраняется токен.
     * @param jwtToken  JWT-токен для аутентификации.
     */
    private void saveUserToken(UserEntity user, String jwtToken){
        // Создаем объект токена
        var token  = Token.builder()
                .user(user)
                .token(jwtToken)
                .revoked(false)
                .expired(false)
                .build();
        // Сохраняем токен в репозитории
        tokenRepository.save(token);
    }
    /**
     * Аутентифицирует пользователя.
     *
     * @param request Запрос на аутентификацию.
     * @return Ответ с JWT-токеном для аутентификации.
     */
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Проверяем аутентификацию пользователя
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
// Находим пользователя по электронной почте
        var user = repository.findByEmail(request.getEmail()).orElseThrow();

        // Устанавливаем приоритет роли в зависимости от указанной роли в запросе
//        if(request.getRole().equals(RoleDto.ADMIN.name())){
//            user.setRolePriority(RoleDto.ADMIN.getPriority());
//        }else{
//            user.setRolePriority(RoleDto.USER.getPriority());
//        }
        // Сохраняем пользователя
//        repository.save(user);
        // Генерируем JWT-токен для аутентификации
        var jwtToken = jwtService.generateToken(user);
        // Отзываем все предыдущие токены пользователя
        //revokeAllUserTokens(user);
        // Сохраняем новый токен пользователя
        //saveUserToken(user,jwtToken);
        // Возвращаем ответ с токеном
//        return AuthenticationResponse.builder()
//                .token(jwtToken).build();
        return null;

    }


    /**
     * Отзывает все токены пользователя.
     *
     * @param user Пользователь, для которого отзываются токены.
     */
    private void revokeAllUserTokens(UserEntity user){
        // Находим все действующие токены пользователя
        var validTokens = tokenRepository.findAllValidTokenByUser(Long.valueOf(user.getId()));
        if(validTokens.isEmpty()){
            // Если нет действующих токенов, завершаем метод
            return;
        }else{
            // Отзываем каждый действующий токен
            validTokens.forEach(t->{

                t.setExpired(true);
                t.setRevoked(true);
            });
            // Сохраняем изменения в репозитории
            tokenRepository.saveAll(validTokens);
        }

    }






}
