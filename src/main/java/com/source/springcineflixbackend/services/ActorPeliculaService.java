package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.ActorPelicula;

import java.util.Collection;

public interface ActorPeliculaService {
    ActorPelicula create(ActorPelicula ActorPelicula);
    Collection<ActorPelicula> list(int limit);
    ActorPelicula get(Long id);
    ActorPelicula update(ActorPelicula ActorPelicula);

    Boolean delete(Long id);
}
