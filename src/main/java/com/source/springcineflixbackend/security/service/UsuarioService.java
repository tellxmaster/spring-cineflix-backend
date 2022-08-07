package com.source.springcineflixbackend.security.service;

import com.source.springcineflixbackend.security.entity.Usuario;
import com.source.springcineflixbackend.security.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;

    public Optional<Usuario> getByEmail(String email){
        return usuarioRepo.findByEmail(email);
    }

    public boolean existsByEmail(String email){
        return usuarioRepo.existsUsuarioByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepo.save(usuario);
    }

}
