package com.source.springcineflixbackend.security.controller;

import com.source.springcineflixbackend.security.dto.JwtDto;
import com.source.springcineflixbackend.security.dto.LoginUsuario;
import com.source.springcineflixbackend.security.dto.Mensaje;
import com.source.springcineflixbackend.security.dto.NewUsuario;
import com.source.springcineflixbackend.security.entity.Rol;
import com.source.springcineflixbackend.security.entity.Usuario;
import com.source.springcineflixbackend.security.enums.RolNombre;
import com.source.springcineflixbackend.security.jwt.JwtProvider;
import com.source.springcineflixbackend.security.service.RolService;
import com.source.springcineflixbackend.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UsuarioController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Email o Password Erroneo"),HttpStatus.BAD_REQUEST);
        } else if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("El email ingresado ya esta utilizado"), HttpStatus.BAD_REQUEST);
        }
            Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
            List<Rol> roles = new ArrayList<Rol>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
            if(nuevoUsuario.getRoles().contains("admin")){
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            }
            usuario.setRoles(roles);
            usuarioService.save(usuario);
            return new ResponseEntity(new Mensaje("Usuario Guardado"), HttpStatus.CREATED);


    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Email o Password Erroneo"),HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
