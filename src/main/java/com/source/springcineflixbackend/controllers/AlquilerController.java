package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.*;
import com.source.springcineflixbackend.services.implementations.AlquilerServiceImpl;
import com.source.springcineflixbackend.services.implementations.PeliculaServiceImpl;
import com.source.springcineflixbackend.services.implementations.SocioServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/alquiler")
@RequiredArgsConstructor
public class AlquilerController {
    
    private final AlquilerServiceImpl alquilerService;
    
    private final SocioServiceImpl socioService;

    private final PeliculaServiceImpl peliculaService;
    
    @GetMapping("/list")
    public ResponseEntity<Response> getAlquileres(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres",alquilerService.list(30)))
                        .message("Alquileres Obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save/socio/{socId}/pelicula/{pelId}")
    public ResponseEntity<Response> saveAlquiler(@RequestBody Alquiler alquiler, @PathVariable Long socId, @PathVariable Long pelId){
        Socio socio = socioService.get(socId);
        alquiler.asignarSocio(socio);
        Pelicula pelicula =  peliculaService.get(pelId);
        alquiler.asignarPelicula(pelicula);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres",alquilerService.create(alquiler)))
                        .message("Alquiler creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getAlquiler(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres",alquilerService.get(id)))
                        .message("Alquiler obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateAlquiler(@RequestBody Alquiler alquiler){
        Socio socio = socioService.get(alquiler.getSocio().getId());
        Pelicula pelicula = peliculaService.get(alquiler.getPeliculaAlq().getId());
        alquiler.asignarSocio(socio);
        alquiler.asignarPelicula(pelicula);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres",alquilerService.update(alquiler)))
                        .message("Alquiler Actualizado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAlquiler(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres",alquilerService.delete(id)))
                        .message("Alquiler eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }




}
