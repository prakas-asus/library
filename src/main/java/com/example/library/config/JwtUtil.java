package com.example.library.config;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtUtil {
    private final Algorithm algorithm;
    private final long expirationMs;

    public JwtUtil(@Value("${app.jwt.secret}") String secret,
            @Value("${app.jwt.expiration-ms}") long expirationMs) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.expirationMs = expirationMs;
    }

    public String generateToken(String username, Map<String, String> claims) {
        var now = System.currentTimeMillis();
        var jwt = JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date(now))
                .withExpiresAt(new Date(now + expirationMs));

        if (claims != null) {
            claims.forEach(jwt::withClaim);
        }

        return jwt.sign(algorithm);
    }

    public DecodedJWT validate(String token) {
        return JWT.require(algorithm).build().verify(token);
    }
}
