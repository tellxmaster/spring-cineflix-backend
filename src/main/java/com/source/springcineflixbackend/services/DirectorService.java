package com.source.springcineflixbackend.services;


import com.source.springcineflixbackend.models.Director;

import java.util.Collection;

public interface DirectorService {
    Director create(Director director);
    Collection<Director> list(int limit);
    Director get(Long id);
    Director update(Director director);
    Boolean delete(Long id);
}
