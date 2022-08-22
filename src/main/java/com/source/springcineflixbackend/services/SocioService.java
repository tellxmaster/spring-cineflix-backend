package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.Socio;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

public interface SocioService {
    Socio create(Socio socio);
    Collection<Socio> list(int limit);
    Socio get(Long id);
    Socio update(Socio socio);
    Boolean delete(Long id);

}
