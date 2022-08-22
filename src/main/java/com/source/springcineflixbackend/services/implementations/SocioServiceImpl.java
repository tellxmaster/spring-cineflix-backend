package com.source.springcineflixbackend.services.implementations;


import com.source.springcineflixbackend.models.Socio;
import com.source.springcineflixbackend.repositories.SocioRepository;
import com.source.springcineflixbackend.services.SocioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepo;

    @Override
    public Socio create(Socio socio) {
        log.info("Guardando nuevo Socio: {}",socio.getNombre());
        return socioRepo.save(socio);
    }

    @Override
    public Collection<Socio> list(int limit) {
        log.info("Obteniendo datos de los Socios");
        return socioRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Socio get(Long id) {
        log.info("Obteniendo datos del Socio con ID: {}", id);
        return socioRepo.findById(id).get();
    }

    @Override
    public Socio update(Socio socio) {
        log.info("Actualizando datos del Socio: {}",socio.getNombre());
        return socioRepo.save(socio);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Socio con ID: {}", id);
        socioRepo.deleteById(id);
        return TRUE;
    }



}
