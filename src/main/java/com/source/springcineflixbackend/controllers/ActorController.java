package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Actor;
import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.models.Sexo;
import com.source.springcineflixbackend.services.implementations.ActorServiceImpl;
import com.source.springcineflixbackend.services.implementations.SexoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorServiceImpl actorService;

    @Autowired
    SexoServiceImpl sexoService;

    @GetMapping("/list")
    public ResponseEntity<Response> getActores(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores",actorService.list(30)))
                        .message("Actores Obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save/sexo/{sexId}")
    public ResponseEntity<Response> saveActor(@RequestBody Actor actor,@PathVariable Long sexId){
        Sexo sexo = sexoService.get(sexId);
        actor.asignarSexo(sexo);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores",actorService.create(actor)))
                        .message("Actor creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getActor(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores",actorService.get(id)))
                        .message("Actor obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateActor(@RequestBody Actor actor){
        Actor act = actorService.get(actor.getId());
        actor.asignarSexo(act.getSexo());
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores",actorService.update(actor)))
                        .message("Actor Actualizado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteActor(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores",actorService.delete(id)))
                        .message("Actor eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
