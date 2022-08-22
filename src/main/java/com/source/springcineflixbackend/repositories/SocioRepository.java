package com.source.springcineflixbackend.repositories;

import com.source.springcineflixbackend.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface SocioRepository extends JpaRepository<Socio,Long> {
    List<Socio> findByCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
