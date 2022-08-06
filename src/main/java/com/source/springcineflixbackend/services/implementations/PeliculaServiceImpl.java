package com.source.springcineflixbackend.services.implementations;

import com.source.springcineflixbackend.models.Pelicula;
import com.source.springcineflixbackend.repositories.PeliculaRepository;
import com.source.springcineflixbackend.services.PeliculaService;
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
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepo;
    @Override
    public Pelicula create(Pelicula pelicula) {
        log.info("Guardando nueva Pelicula: {}",pelicula.getId());
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Collection<Pelicula> list(int limit) {
        log.info("Obteniendo datos de las Peliculas");
        return peliculaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Pelicula get(Long id) {
        log.info("Obteniendo datos de la Pelicula con ID: {}", id);
        return peliculaRepo.findById(id).get();
    }

    @Override
    public Pelicula update(Pelicula pelicula) {
        log.info("Actualizando datos de la Pelicula: {}",pelicula.getId());
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando la Pelicula con ID: {}", id);
        peliculaRepo.deleteById(id);
        return TRUE;
    }
}
