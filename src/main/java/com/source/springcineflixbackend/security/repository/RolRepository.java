package com.source.springcineflixbackend.security.repository;

import com.source.springcineflixbackend.security.entity.Rol;
import com.source.springcineflixbackend.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
