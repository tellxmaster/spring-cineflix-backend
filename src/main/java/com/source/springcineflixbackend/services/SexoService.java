package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Sexo;

import java.util.Collection;

public interface SexoService {
    Sexo create(Sexo sexo);
    Collection<Sexo> list(int limit);
    Sexo get(Long id);
    Sexo update(Sexo sexo);
    Boolean delete(Long id);
}
