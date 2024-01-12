package com.eomaxl.apigateway.util;

import io.jsonwebtoken.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import  io.jsonwebtoken.Jwts

@Component
public class JwtUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    public Claims getClaim(final String token){
        try{
            Claims body = Jwts.parserBuilder().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return body;
        } catch (Exception e){
            System.out.println(e.getMessage() +" :: "+e);
            return null;
        }
    }

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().verifyWith(jwtSecret).build().parseSignedClaims(authToken);
            return true;
        } catch (MalformedJwtException e) {
            LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT token: {}", e.getMessage());
            throw new MalformedJwtException(e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.error("JwtUtils | validateJwtToken | JWT token is expired: {}", e.getMessage());
            throw new ExpiredJwtException(null,null,e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JwtUtils | validateJwtToken | JWT token is unsupported: {}", e.getMessage());
            throw new UnsupportedJwtException(e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JwtUtils | validateJwtToken | JWT claims string is empty: {}", e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
