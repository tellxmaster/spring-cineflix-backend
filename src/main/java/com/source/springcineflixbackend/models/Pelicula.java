package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "pelicula")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pel_nombre")
    private String pel_nombre;

    @Column(name="pel_costo")
    private double pel_costo;

    @Column(name = "pel_fecha_est")
    private Date pel_fecha_est;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculaAct")
    private List<ActorPelicula> actor_peliculas;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculaAlq")
    private List<Alquiler> alquilers;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gen_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_GENERO_PELICULA"))
    @ToString.Exclude
    private Genero genero;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dir_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_DIRECTOR_PELICULA"))
    @ToString.Exclude
    private Director director;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "for_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_FORMATO_PELICULA"))
    @ToString.Exclude
    private Formato formato;

    public void asignarGenero(Genero genero) {
        this.genero = genero;
    }
    public void asignarDirector(Director director) {
        this.director = director;
    }
    public void asignarFormato(Formato formato) {
        this.formato = formato;
    }
}
