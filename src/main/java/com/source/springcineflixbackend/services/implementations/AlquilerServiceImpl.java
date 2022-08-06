package com.source.springcineflixbackend.services.implementations;


import com.source.springcineflixbackend.models.Alquiler;
import com.source.springcineflixbackend.repositories.AlquilerRepository;
import com.source.springcineflixbackend.services.AlquilerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AlquilerServiceImpl implements AlquilerService {

    private final AlquilerRepository alquilerRepo;

    @Override
    public Alquiler create(Alquiler alquiler) {
        log.info("Guardando nuevo Alquiler: {}",alquiler.getId());
        return alquilerRepo.save(alquiler);
    }

    @Override
    public Collection<Alquiler> list(int limit) {
        log.info("Obteniendo datos de los Alquiler");
        return alquilerRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Alquiler get(Long id) {
        log.info("Obteniendo datos del Actor Pelicula con ID: {}", id);
        return alquilerRepo.findById(id).get();
    }

    @Override
    public Alquiler update(Alquiler alquiler) {
        log.info("Actualizando datos del Alquiler: {}",alquiler.getId());
        return alquilerRepo.save(alquiler);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Alquiler con ID: {}", id);
        alquilerRepo.deleteById(id);
        return TRUE;
    }
}
