package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Formato;

import java.util.Collection;

public interface FormatoService {
    Formato create(Formato formato);
    Collection<Formato> list(int limit);
    Formato get(Long id);
    Formato update(Formato formato);
    Boolean delete(Long id);
}
