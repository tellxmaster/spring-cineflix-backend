package com.source.springcineflixbackend.services;

import com.source.springcineflixbackend.models.*;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface DashboardService {
    public Collection<Alquiler> getAlquileresPerMonth(LocalDateTime inicio, LocalDateTime fin);

    public int getNumByGenero(Genero genero);

    public Collection<Socio> getSociosPerMonth(LocalDateTime inicio, LocalDateTime fin);
    Pelicula getTopPelicula(String mes);
    Collection<Alquiler> getAlquilers();
    Collection<DataCount> getDataCount(String mes);
}
