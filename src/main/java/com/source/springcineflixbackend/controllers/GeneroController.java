package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Genero;
import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.services.implementations.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroServiceImpl generoService;

    @GetMapping("/list")
    public ResponseEntity<Response> getGeneros(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("generos",generoService.list(30)))
                        .message("Generos obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveGenero(@RequestBody @Valid Genero genero){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("generos",generoService.create(genero)))
                        .message("Genero creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getGenero(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("generos",generoService.get(id)))
                        .message("Genero obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteGenero(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("generos",generoService.delete(id)))
                        .message("Genero eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
