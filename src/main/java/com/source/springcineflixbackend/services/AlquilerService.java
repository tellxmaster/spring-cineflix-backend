package com.source.springcineflixbackend.services;


import com.source.springcineflixbackend.models.Alquiler;

import java.util.Collection;

public interface AlquilerService {
    Alquiler create(Alquiler Alquiler);
    Collection<Alquiler> list(int limit);
    Alquiler get(Long id);
    Alquiler update(Alquiler Alquiler);
    Boolean delete(Long id);
}
