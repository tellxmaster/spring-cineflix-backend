package com.source.springcineflixbackend.services.implementations;

import com.source.springcineflixbackend.models.Genero;
import com.source.springcineflixbackend.repositories.GeneroRepository;
import com.source.springcineflixbackend.services.GeneroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepo;

    @Override
    public Genero create(Genero genero) {
        log.info("Guardando nuevo Genero: {}",genero.getId());
        return generoRepo.save(genero);
    }

    @Override
    public Collection<Genero> list(int limit) {
        log.info("Obteniendo datos de los Genero");
        return generoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Genero get(Long id) {
        log.info("Obteniendo datos del Genero con ID: {}", id);
        return generoRepo.findById(id).get();
    }

    @Override
    public Genero update(Genero genero) {
        log.info("Actualizando datos del Actor Pelicula: {}",genero.getId());
        return generoRepo.save(genero);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Genero con ID: {}", id);
        generoRepo.deleteById(id);
        return TRUE;
    }
}
