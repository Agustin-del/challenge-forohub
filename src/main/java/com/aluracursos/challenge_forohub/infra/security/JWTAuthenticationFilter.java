package com.aluracursos.challenge_forohub.infra.security;

import com.aluracursos.challenge_forohub.services.security.AuthenticationService;
import com.aluracursos.challenge_forohub.services.security.JwtTokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService tokenService;
    private final AuthenticationService authenticationService;

    public JWTAuthenticationFilter(JwtTokenService tokenService, AuthenticationService authenticationService) {
        this.tokenService = tokenService;
        this.authenticationService = authenticationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if(tokenService.validateToken(token)){
                authenticationService.authenticateUserWithToken(token);
            }
        }
        filterChain.doFilter(request, response);
    }
}
