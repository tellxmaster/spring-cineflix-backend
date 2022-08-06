package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Genero;

import java.util.Collection;

public interface GeneroService {
    Genero create(Genero genero);
    Collection<Genero> list(int limit);
    Genero get(Long id);
    Genero update(Genero genero);
    Boolean delete(Long id);
}
