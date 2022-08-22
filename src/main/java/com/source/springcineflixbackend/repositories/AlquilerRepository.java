package com.source.springcineflixbackend.repositories;


import com.source.springcineflixbackend.models.Alquiler;
import com.source.springcineflixbackend.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler,Long> {
    List<Alquiler> findByCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

}
