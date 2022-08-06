package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Pelicula;

import java.util.Collection;

public interface PeliculaService {
    Pelicula create(Pelicula pelicula);
    Collection<Pelicula> list(int limit);
    Pelicula get(Long id);
    Pelicula update(Pelicula pelicula);
    Boolean delete(Long id);
}
