package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Actor;
import com.source.springcineflixbackend.models.Sexo;
import com.source.springcineflixbackend.repositories.ActorRepository;
import com.source.springcineflixbackend.repositories.SexoRepository;
import com.source.springcineflixbackend.services.implementations.ActorServiceImpl;
import com.source.springcineflixbackend.services.implementations.SexoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorServiceImpl actorService;

    @Autowired
    ActorRepository actorRepo;

    @Autowired
    SexoServiceImpl sexoService;

    @Autowired
    SexoRepository sexoRepo;

    @GetMapping()
    public Collection<Actor> getActores(){
        return this.actorService.list(30);
    }

    @PostMapping("sexo/{sexId}")
    public Actor saveActor(@RequestBody Actor actor,@PathVariable Long sexId){
        Sexo sexo = sexoService.get(sexId);
        actor.asignarSexo(sexo);
        return this.actorService.create(actor);
    }

    @PutMapping("/{actorId}/sexo/{sexId}")
    Actor asignarSexoActor(@PathVariable Long actorId, @PathVariable Long sexId){
        Actor actor = actorService.get(actorId);
        Sexo sexo = sexoService.get(sexId);
        actor.asignarSexo(sexo);
        return actorService.create(actor);
    }
}
