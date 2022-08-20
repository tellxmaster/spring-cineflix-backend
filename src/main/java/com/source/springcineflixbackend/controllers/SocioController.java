package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.models.Socio;
import com.source.springcineflixbackend.services.implementations.SocioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/socio")
@RequiredArgsConstructor
public class SocioController {

    private final SocioServiceImpl socioService;

    @GetMapping("/list")
    public ResponseEntity<Response> getSocios(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("socios",socioService.list(50)))
                        .message("Socios Obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSocio(@RequestBody Socio socio){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("socio",socioService.create(socio)))
                        .message("Socio creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getSocio(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("socio",socioService.get(id)))
                        .message("Socio obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    
    @PutMapping("/update")
    public ResponseEntity<Response> updateSocio(@RequestBody Socio socio){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("socio",socioService.update(socio)))
                        .message("Socio Actualizado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteSocio(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("socio",socioService.delete(id)))
                        .message("Socio eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
