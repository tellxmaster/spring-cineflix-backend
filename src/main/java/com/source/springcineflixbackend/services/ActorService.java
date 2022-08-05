package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Actor;

import java.util.Collection;

public interface ActorService {
    Actor create(Actor actor);
    Collection<Actor> list(int limit);
    Actor get(Long id);
    Actor update(Actor Actor);
    Boolean delete(Long id);
}
