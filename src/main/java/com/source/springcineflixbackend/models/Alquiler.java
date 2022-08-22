package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "alquiler")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "alq_fecha_desde")
    private Date alq_fecha_desde;

    @Column(name = "alq_fecha_hasta")
    private Date alq_fecha_hasta;

    @Column(name = "alq_valor")
    private double alq_valor;

    @Column(name = "alq_fecha_entrega")
    private Date alq_fecha_entrega;

    @Column(name = "updated")
    @UpdateTimestamp
    private LocalDateTime updated;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "soc_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_PELICULA_ALQUILER"))
    @ToString.Exclude
    private Socio socio;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pel_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_SOCIO_ALQUILER"))
    @ToString.Exclude
    private Pelicula peliculaAlq;
    public void asignarSocio(Socio socio) {
        this.socio = socio;
    }
    public void asignarPelicula(Pelicula pelicula) {
        this.peliculaAlq = pelicula;
    }
}
