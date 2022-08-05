package com.source.springcineflixbackend.services.implementations;

import com.source.springcineflixbackend.models.Sexo;
import com.source.springcineflixbackend.repositories.SexoRepository;
import com.source.springcineflixbackend.services.SexoService;
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
public class SexoServiceImpl implements SexoService {
    private final SexoRepository sexoRepo;

    @Override
    public Sexo create(Sexo sexo) {
        log.info("Guardando nuevo Sexo: {}",sexo.getSex_nombre());
        return sexoRepo.save(sexo);
    }

    @Override
    public Collection<Sexo> list(int limit) {
        log.info("Obteniendo datos de los Sexos");
        return sexoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Sexo get(Long id) {
        log.info("Obteniendo datos del Sexo con ID: {}", id);
        return sexoRepo.findById(id).get();
    }

    @Override
    public Sexo update(Sexo sexo) {
        log.info("Actualizando datos del Sexo: {}",sexo.getSex_nombre());
        return sexoRepo.save(sexo);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Eliminando el Sexo con ID: {}", id);
        sexoRepo.deleteById(id);
        return TRUE;
    }
}
