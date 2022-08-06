package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private int alq_fecha_desde;

    @Column(name = "alq_fecha_hasta")
    private int alq_fecha_hasta;

    @Column(name = "alq_valor")
    private int alq_valor;

    @Column(name = "alq_fecha_entrega")
    private int alq_fecha_entrega;

    @Column(name="updated_at")
    private LocalDateTime updated_at;

    @Column(name="created_at")
    private LocalDateTime created_at;
}
