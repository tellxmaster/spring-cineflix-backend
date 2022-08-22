package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.models.Sexo;
import com.source.springcineflixbackend.services.implementations.SexoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/sexo")
public class SexoController {
    @Autowired
    SexoServiceImpl sexoService;
    
    @GetMapping("/list")
    public ResponseEntity<Response> getSexos(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("sexos",sexoService.list(30)))
                        .message("Sexos Obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSexo(@RequestBody Sexo sexo){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("sexo",sexoService.create(sexo)))
                        .message("Sexo creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getSexo(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("sexo",sexoService.get(id)))
                        .message("Sexo obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateSexo(@RequestBody Sexo sexo){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("sexo",sexoService.update(sexo)))
                        .message("Sexo Actualizado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteSexo(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("sexo",sexoService.delete(id)))
                        .message("Sexo eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
