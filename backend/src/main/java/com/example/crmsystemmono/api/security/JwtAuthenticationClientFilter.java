//package com.example.crmsystemmono.api.security;
//
//import com.example.crmsystemmono.api.repository.*;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import lombok.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.context.*;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.security.web.authentication.*;
//import org.springframework.stereotype.*;
//import org.springframework.web.filter.*;
//
//import java.io.*;
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthenticationClientFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private ApiKeyService jwtService;
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private ApiKeyRepository tokenRepository;
//    /**
//     * Фильтр аутентификации для обработки JWT-токенов.
//     * Проверяет наличие и валидность токена в заголовке запроса.
//     *
//     * @param request       HTTP-запрос
//     * @param response      HTTP-ответ
//     * @param filterChain   Цепочка фильтров
//     * @throws ServletException если возникла ошибка при обработке запроса
//     * @throws IOException      если возникла ошибка ввода-вывода
//     */
//    @Override
//    protected void doFilterInternal(
//            @NonNull HttpServletRequest request,
//            @NonNull HttpServletResponse response,
//            @NonNull FilterChain filterChain) throws ServletException, IOException {
//// Если запрос относится к пути "/api/v1/auth", пропускаем его без проверки
//        if (request.getServletPath().contains("/api/v1/auth")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        // Получаем заголовок "Authorization"
//        final String authHeader  = request.getHeader("Authorization");
//        final String jwt;
//        final String userEmail;
//        // Проверяем, что заголовок начинается с "Bearer "
//        if(authHeader == null || !authHeader.startsWith("Bearer ")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//
//        jwt = authHeader.substring(7);
//// Извлекаем email пользователя из токена
//        userEmail = jwtService.extractUserEmail(jwt);
//// Если email не пустой и пользователь не аутентифицирован, выполняем дополнительные проверки
//        if(userEmail!=null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//            var isTokenValid = tokenRepository.findByKey(jwt).map(t->t.getValid()).orElse(false);
//// Проверяем валидность токена и его статус
//            if(jwtService.isTokenValid(jwt, userDetails) && isTokenValid){
//                // Создаем аутентификационный токен и устанавливаем его в контекст безопасности
//                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                        userDetails,
//                        null,
//                        userDetails.getAuthorities()
//                );
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//
//            }
//        }// Пропускаем запрос дальше по цепочке фильтров
//        filterChain.doFilter(request,response);
//    }
//}
//
