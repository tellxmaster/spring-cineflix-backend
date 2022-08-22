package com.source.springcineflixbackend.util;

import com.source.springcineflixbackend.models.Socio;
import com.source.springcineflixbackend.security.entity.Rol;
import com.source.springcineflixbackend.security.enums.RolNombre;
import com.source.springcineflixbackend.security.service.RolService;
import com.source.springcineflixbackend.services.SocioService;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    SocioService socioService;

    @Override
    public void run(String... args) throws Exception {
        //Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        //Rol rolUser = new Rol(RolNombre.ROLE_USER);
        //rolService.save(rolUser);
        //rolService.save(rolAdmin);
    }
}
