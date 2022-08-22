package com.source.springcineflixbackend.services.implementations;

import com.source.springcineflixbackend.models.*;

import com.source.springcineflixbackend.repositories.AlquilerRepository;
import com.source.springcineflixbackend.repositories.GeneroRepository;
import com.source.springcineflixbackend.repositories.SocioRepository;
import com.source.springcineflixbackend.services.DashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class DashboardServiceImpl implements DashboardService {
    private final SocioRepository socioRepo;
    private final AlquilerRepository alquilerRepo;

    private final GeneroRepository generoRepo;
    @Override
    public int getNumByGenero(Genero genero) {
        return generoRepo.countAllById(genero.getId());
    }

    @Override
    public Collection<Socio> getSociosPerMonth(LocalDateTime inicio, LocalDateTime fin) {
        log.info("Guardando nuevo Alquiler:");
        return socioRepo.findByCreatedBetween(inicio,fin);
    }

    @Override
    public Collection<Alquiler> getAlquileresPerMonth(LocalDateTime inicio, LocalDateTime fin) {
        log.info("Obteniendo alquileres por Mes:");
        return alquilerRepo.findByCreatedBetween(inicio,fin);
    }

    @Override
    public Pelicula getTopPelicula(String mes) {
        return null;
    }

    @Override
    public Collection<Alquiler> getAlquilers() {
        return null;
    }

    @Override
    public Collection<DataCount> getDataCount(String mes) {
        return null;
    }
}
