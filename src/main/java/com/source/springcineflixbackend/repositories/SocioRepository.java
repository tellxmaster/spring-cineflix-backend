package com.source.springcineflixbackend.repositories;

import com.source.springcineflixbackend.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

public interface SocioRepository extends JpaRepository<Socio,Long> {

}
