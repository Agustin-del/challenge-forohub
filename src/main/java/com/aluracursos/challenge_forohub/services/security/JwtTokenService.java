package com.aluracursos.challenge_forohub.services.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtTokenService {

    private final UserDetailsService userDetails;

    private final Algorithm algorithm = Algorithm.HMAC256("123456");

    public JwtTokenService(UserDetailsService userDetails) {
        this.userDetails = userDetails;
    }

    public String generateToken(Authentication authentication) {
        return JWT.create()
                .withSubject(authentication.getName())
                .withClaim("role", authentication
                        .getAuthorities()
                        .iterator()
                        .next()
                        .getAuthority())
                .withIssuer("forohub")
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(60, ChronoUnit.MINUTES))
                .sign(algorithm);
    }

    public boolean validateToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withIssuer("forohub")
                .build();
        try {

            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            String subject = decodedJWT.getSubject();

            if(decodedJWT.getExpiresAtAsInstant().isBefore(Instant.now())) {
                return false;
            };
            return true;

        } catch(JWTVerificationException e) {
            return false;
        }
    }

    public String  getSubject(String token) {
        return JWT.decode(token).getSubject();
    }
}
