package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Director;
import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.services.implementations.DirectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    DirectorServiceImpl directorService;

    @GetMapping("/list")
    public ResponseEntity<Response> getDirectores(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("directores",directorService.list(30)))
                        .message("Directores obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveDirector(@RequestBody @Valid Director director){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("directores",directorService.create(director)))
                        .message("Director creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getDirector(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("directores",directorService.get(id)))
                        .message("Director obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteDirector(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("directores",directorService.delete(id)))
                        .message("Director eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
