package com.exercise5.exercise5.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    private final String SECRET_KEY = "secret_key";
    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    public String generateToken(String email) {
        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(), SIGNATURE_ALGORITHM.getJcaName());

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token, String email) {
        String tokenEmail = extractEmail(token);
        return (email.equals(tokenEmail) && !isTokenExpired(token));
    }

    public String extractEmail(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
