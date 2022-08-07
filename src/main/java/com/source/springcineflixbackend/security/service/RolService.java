package com.source.springcineflixbackend.security.service;

import com.source.springcineflixbackend.security.entity.Rol;
import com.source.springcineflixbackend.security.enums.RolNombre;
import com.source.springcineflixbackend.security.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RolService {
    private final RolRepository rolRepo;
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepo.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepo.save(rol);
    }
}
