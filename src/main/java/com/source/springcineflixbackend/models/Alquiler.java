package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "alquiler")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "soc_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_PELICULA_ALQUILER"))
    private Socio socio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pel_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_SOCIO_ALQUILER"))
    private Pelicula peliculaAlq;

    @Column(name = "alq_fecha_desde")
    private Date alq_fecha_desde;

    @Column(name = "alq_fecha_hasta")
    private Date alq_fecha_hasta;

    @Column(name = "alq_valor")
    private double alq_valor;

    @Column(name = "alq_fecha_entrega")
    private Date alq_fecha_entrega;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="created_at")
    private Date created_at;

    public void asignarSocio(Socio socio) {
        this.socio = socio;
    }
    public void asignarPelicula(Pelicula pelicula) {
        this.peliculaAlq = pelicula;
    }
}
