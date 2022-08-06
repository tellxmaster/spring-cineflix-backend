package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Socio;

import java.util.Collection;

public interface SocioService {
    Socio create(Socio socio);
    Collection<Socio> list(int limit);
    Socio get(Long id);
    Socio update(Socio socio);
    Boolean delete(Long id);
}
