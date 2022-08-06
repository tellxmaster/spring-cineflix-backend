package com.source.springcineflixbackend.services.implementations;


import com.source.springcineflixbackend.models.ActorPelicula;
import com.source.springcineflixbackend.repositories.ActorPeliculaRepository;
import com.source.springcineflixbackend.services.ActorPeliculaService;
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
public class ActorPeliculaServiceImpl implements ActorPeliculaService {

    private final ActorPeliculaRepository actorPeliculaRepo;

    @Override
    public ActorPelicula create(ActorPelicula actorPelicula) {
        log.info("Guardando nuevo Actor Pelicula: {}",actorPelicula.getActor());
        return actorPeliculaRepo.save(actorPelicula);
    }

    @Override
    public Collection<ActorPelicula> list(int limit) {
        log.info("Obteniendo datos de los Actor Peliculas");
        return actorPeliculaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public ActorPelicula get(Long id) {
        log.info("Obteniendo datos del Actor Pelicula con ID: {}", id);
        return actorPeliculaRepo.findById(id).get();
    }

    @Override
    public ActorPelicula update(ActorPelicula actorPelicula) {
        log.info("Actualizando datos del Actor Pelicula: {}",actorPelicula.getActor());
        return actorPeliculaRepo.save(actorPelicula);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Actor Pelicula con ID: {}", id);
        actorPeliculaRepo.deleteById(id);
        return TRUE;
    }
}
