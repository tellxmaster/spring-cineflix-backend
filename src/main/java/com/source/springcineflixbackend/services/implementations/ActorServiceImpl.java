package com.source.springcineflixbackend.services.implementations;

import com.source.springcineflixbackend.models.Actor;
import com.source.springcineflixbackend.repositories.ActorRepository;
import com.source.springcineflixbackend.services.ActorService;
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
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepo;

    @Override
    public Actor create(Actor actor) {
        log.info("Guardando nuevo Actor Pelicula: {}",actor.getId());
        return actorRepo.save(actor);
    }

    @Override
    public Collection<Actor> list(int limit) {
        log.info("Obteniendo datos de los Actor Peliculas");
        return actorRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Actor get(Long id) {
        log.info("Obteniendo datos del Actor Pelicula con ID: {}", id);
        return actorRepo.findById(id).get();
    }

    @Override
    public Actor update(Actor actor) {
        log.info("Actualizando datos del Actor Pelicula: {}",actor.getId());
        return actorRepo.save(actor);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Actor Pelicula con ID: {}", id);
        actorRepo.deleteById(id);
        return TRUE;
    }
}
