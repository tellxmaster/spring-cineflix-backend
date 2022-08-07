package com.source.springcineflixbackend.security.repository;

import com.source.springcineflixbackend.security.entity.Rol;
import com.source.springcineflixbackend.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

