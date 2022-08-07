package com.source.springcineflixbackend.security.jwt;

import com.source.springcineflixbackend.security.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
    //Valida el token y se ejecuta en cada ejecución y permite el acceso

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(req);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getUserNameFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            filterChain.doFilter(req,res);
        }catch (Exception e){
            log.error("Error en doFilter"+e);
        }
    }

    private String getToken(HttpServletRequest req){
        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer", "");
        }else{
            return null;
        }
    }
}
