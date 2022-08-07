package com.source.springcineflixbackend.security.jwt;


import com.source.springcineflixbackend.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Date;

@Component
@Slf4j
public class JwtProvider {
    //Genera el token

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            log.error("Token mal generado");
        }catch (UnsupportedJwtException e){
            log.error("Token no soportado");
        }catch (ExpiredJwtException e){
            log.error("Token expirado");
        }catch (IllegalArgumentException e){
            log.error("Token vacio");
        }catch (SignatureException e){
            log.error("Error con la Firma");
        }
        return false;
    }
}
