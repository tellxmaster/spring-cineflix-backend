package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.*;
import com.source.springcineflixbackend.services.implementations.ActorPeliculaServiceImpl;
import com.source.springcineflixbackend.services.implementations.ActorServiceImpl;
import com.source.springcineflixbackend.services.implementations.PeliculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/actor-pelicula")
public class ActorPeliculaController {

    @Autowired
    ActorPeliculaServiceImpl actorPeliculaService;
    @Autowired
    ActorServiceImpl actorService;

    @Autowired
    PeliculaServiceImpl peliculaService;

    @GetMapping("/list")
    public ResponseEntity<Response> getActoresPelicula(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores_peliculas",actorPeliculaService.list(30)))
                        .message("Actores Pelicula Obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save/actor/{actId}/pelicula/{pelId}")
    public ResponseEntity<Response> saveActorPelicula(@RequestBody ActorPelicula actor_pelicula, @PathVariable Long actId, @PathVariable Long pelId){
        Actor actor = actorService.get(actId);
        actor_pelicula.asignarActor(actor);
        Pelicula pelicula = peliculaService.get(pelId);
        actor_pelicula.asignarPelicula(pelicula);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores_peliculas",actorPeliculaService.create(actor_pelicula)))
                        .message("Actor Pelicula creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getActorPelicula(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores_peliculas",actorPeliculaService.get(id)))
                        .message("Actor Pelicula obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update/actor/{actId}/pelicula/{pelId}")
    public ResponseEntity<Response> updateActorPelicula(@RequestBody ActorPelicula actor_pelicula, @PathVariable Long actId, @PathVariable Long pelId){
        Actor actor = actorService.get(actId);
        actor_pelicula.asignarActor(actor);
        Pelicula pelicula = peliculaService.get(pelId);
        actor_pelicula.asignarPelicula(pelicula);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores_peliculas",actorPeliculaService.update(actor_pelicula)))
                        .message("Actor Pelicula Actualizado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteActorPelicula(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("actores_peliculas",actorPeliculaService.delete(id)))
                        .message("Actor Pelicula eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
