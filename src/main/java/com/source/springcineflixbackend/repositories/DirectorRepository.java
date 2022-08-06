package com.source.springcineflixbackend.repositories;

import com.source.springcineflixbackend.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Long> {
}
