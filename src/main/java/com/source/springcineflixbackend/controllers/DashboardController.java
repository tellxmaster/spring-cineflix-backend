package com.source.springcineflixbackend.controllers;

import com.source.springcineflixbackend.models.Response;
import com.source.springcineflixbackend.services.GeneroService;
import com.source.springcineflixbackend.services.implementations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final ActorServiceImpl actorService;
    private final AlquilerServiceImpl alquilerService;
    private final DirectorServiceImpl directorService;
    private final FormatoServiceImpl formatoService;
    private final GeneroServiceImpl generoService;
    private final PeliculaServiceImpl peliculaService;
    private final SexoServiceImpl sexoService;
    private final SocioServiceImpl socioService;
    private final DashboardServiceImpl dashboardService;

    @GetMapping("/socios-per-month/{mes}")
    public ResponseEntity<Response> getSocios(@PathVariable int mes){
        LocalDateTime inicio = LocalDateTime.of(2022,mes,01,00,00,00);
        LocalDateTime fin = LocalDateTime.of(2022,mes,31,00,00,00);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("socios", dashboardService.getSociosPerMonth(inicio,fin)))
                        .message("Socios Por Mes")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/alquileres-per-month/{mes}")
    public ResponseEntity<Response> getAlquilers(@PathVariable int mes){
        LocalDateTime inicio = LocalDateTime.of(2022,01,01,00,00,00);
        LocalDateTime fin = LocalDateTime.of(2022,12,31,00,00,00);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres", dashboardService.getAlquileresPerMonth(inicio, fin)))
                        .message("Alquileres Por Mes")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/generos-inventory/{genId}")
    public ResponseEntity<Response> getGeneros(@PathVariable Long genId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("alquileres", dashboardService.getNumByGenero(generoService.get(genId))))
                        .message("Alquileres Por Mes")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
