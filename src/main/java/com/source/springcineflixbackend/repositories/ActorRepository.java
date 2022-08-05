package com.source.springcineflixbackend.repositories;

import com.source.springcineflixbackend.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {

}
