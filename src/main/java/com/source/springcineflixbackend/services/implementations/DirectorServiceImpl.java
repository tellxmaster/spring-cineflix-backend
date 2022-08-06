package com.source.springcineflixbackend.services.implementations;

import com.source.springcineflixbackend.models.Director;
import com.source.springcineflixbackend.repositories.DirectorRepository;
import com.source.springcineflixbackend.services.DirectorService;
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
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepo;

    @Override
    public Director create(Director director) {
        log.info("Guardando nuevo Director: {}",director.getId());
        return directorRepo.save(director);
    }

    @Override
    public Collection<Director> list(int limit) {
        log.info("Obteniendo datos de los Director");
        return directorRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Director get(Long id) {
        log.info("Obteniendo datos del Director con ID: {}", id);
        return directorRepo.findById(id).get();
    }

    @Override
    public Director update(Director director) {
        log.info("Actualizando datos del Director: {}",director.getId());
        return directorRepo.save(director);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Director con ID: {}", id);
        directorRepo.deleteById(id);
        return TRUE;
    }
}
