package com.source.springcineflixbackend.repositories;

import com.source.springcineflixbackend.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
