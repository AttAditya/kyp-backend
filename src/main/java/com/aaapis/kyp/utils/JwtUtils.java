package com.aaapis.kyp.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.AuthenticationException;
import java.util.Date;

public class JwtUtils {
    private static final String SECRET = "your_secret_here";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    private static final String ISSUER = "your_issuer_here";

    public static String generateToken(String userId) {
        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);

        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withClaim("userId", userId)
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static DecodedJWT decodeToken(String token) throws JWTDecodeException, JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER)
                .build()
                .verify(token);
    }

    public static String getUserIdFromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("userId").asString();
    }
}
