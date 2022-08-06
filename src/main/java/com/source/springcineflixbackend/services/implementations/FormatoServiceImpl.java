package com.source.springcineflixbackend.services.implementations;


import com.source.springcineflixbackend.models.Formato;
import com.source.springcineflixbackend.repositories.FormatoRepository;
import com.source.springcineflixbackend.services.FormatoService;
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
public class FormatoServiceImpl implements FormatoService {

    private final FormatoRepository formatoRepo;

    @Override
    public Formato create(Formato formato) {
        log.info("Guardando nuevo Formato: {}",formato.getId());
        return formatoRepo.save(formato);
    }

    @Override
    public Collection<Formato> list(int limit) {
        log.info("Obteniendo datos de los Formato");
        return formatoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Formato get(Long id) {
        log.info("Obteniendo datos del Formato con ID: {}", id);
        return formatoRepo.findById(id).get();
    }

    @Override
    public Formato update(Formato formato) {
        log.info("Actualizando datos del Formato: {}",formato.getId());
        return formatoRepo.save(formato);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Formato con ID: {}", id);
        formatoRepo.deleteById(id);
        return TRUE;
    }
}
