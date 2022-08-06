package com.source.springcineflixbackend.repositories;


import com.source.springcineflixbackend.models.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler,Long> {
}
