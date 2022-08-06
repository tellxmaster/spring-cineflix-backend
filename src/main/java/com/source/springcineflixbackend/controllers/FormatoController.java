package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Formato;
import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.services.implementations.FormatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/formato")
public class FormatoController {

    @Autowired
    FormatoServiceImpl formatoService;

    @GetMapping("/list")
    public ResponseEntity<Response> getFormatos(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("formatos",formatoService.list(30)))
                        .message("Formatos obtenidos")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveFormato(@RequestBody @Valid Formato formato){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("formatos",formatoService.create(formato)))
                        .message("Formato creado")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getFormato(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("formatos",formatoService.get(id)))
                        .message("Formato obtenido")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteFormato(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("formatos",formatoService.delete(id)))
                        .message("Formato eliminado")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
