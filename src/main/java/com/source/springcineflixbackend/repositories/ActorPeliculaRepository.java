package com.source.springcineflixbackend.repositories;

import com.source.springcineflixbackend.models.ActorPelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorPeliculaRepository extends JpaRepository<ActorPelicula,Long> {

}
