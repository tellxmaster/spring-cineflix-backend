package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.*;
import com.source.springcineflixbackend.services.implementations.DirectorServiceImpl;
import com.source.springcineflixbackend.services.implementations.FormatoServiceImpl;
import com.source.springcineflixbackend.services.implementations.GeneroServiceImpl;
import com.source.springcineflixbackend.services.implementations.PeliculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    PeliculaServiceImpl peliculaService;

    @Autowired
    GeneroServiceImpl generoService;

    @Autowired
    DirectorServiceImpl directorService;

    @Autowired
    FormatoServiceImpl formatoService;
    
    @GetMapping("/list")
    public ResponseEntity<Response> getPeliculas(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("peliculas", peliculaService.list(30)))
                        .message("Peliculas Obtenidas")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    
    @PostMapping("/save/genero/{genId}/director/{dirId}/formato/{forId}")
    public ResponseEntity<Response> savePelicula(@RequestBody @Valid  Pelicula pelicula, @PathVariable Long genId, @PathVariable Long dirId, @PathVariable Long forId){
        Genero genero = generoService.get(genId);
        Director director = directorService.get(dirId);
        Formato formato = formatoService.get(forId);
        pelicula.asignarGenero(genero);
        pelicula.asignarDirector(director);
        pelicula.asignarFormato(formato);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("peliculas", peliculaService.create(pelicula)))
                        .message("Pelicula creada")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPelicula(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("pelicula",peliculaService.get(id)))
                        .message("Pelicula obtenida")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    
    @PutMapping("/update")
    public ResponseEntity<Response> updatePelicula(@RequestBody Pelicula pelicula){
        Pelicula pel = peliculaService.get(pelicula.getId());
        pelicula.asignarGenero(pel.getGenero());
        pelicula.asignarDirector(pel.getDirector());
        pelicula.asignarFormato(pel.getFormato());
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("pelicula",peliculaService.update(pelicula)))
                        .message("Pelicula Actualizada")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePelicula(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("pelicula",peliculaService.delete(id)))
                        .message("Pelicula eliminada")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
