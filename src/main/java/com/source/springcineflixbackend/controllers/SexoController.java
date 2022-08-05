package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Sexo;
import com.source.springcineflixbackend.services.implementations.SexoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sexo")
public class SexoController {
    @Autowired
    SexoServiceImpl sexoService;

    @GetMapping()
    public Collection<Sexo> getSexos(){
        return this.sexoService.list(30);
    }

    @PostMapping()
    public Sexo saveActor(@RequestBody Sexo sexo){
        return this.sexoService.create(sexo);
    }
}
