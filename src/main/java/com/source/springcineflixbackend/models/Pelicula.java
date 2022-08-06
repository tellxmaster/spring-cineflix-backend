package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="pel_nombre")
    private String pel_nombre;

    @Column(name="pel_costo")
    private double pel_costo;

    @Column(name = "pel_fecha_est")
    private Date pel_fecha_est;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="created_at")
    private Date created_at;

    @OneToMany(mappedBy = "peliculaAct")
    private List<ActorPelicula> actor_peliculas;

    @OneToMany(mappedBy = "peliculaAlq")
    private List<Alquiler> alquilers;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gen_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_GENERO_PELICULA"))
    private Genero genero;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dir_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_DIRECTOR_PELICULA"))
    private Director director;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "for_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_FORMATO_PELICULA"))
    private Formato formato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPel_nombre() {
        return pel_nombre;
    }

    public void setPel_nombre(String pel_nombre) {
        this.pel_nombre = pel_nombre;
    }

    public double getPel_costo() {
        return pel_costo;
    }

    public void setPel_costo(double pel_costo) {
        this.pel_costo = pel_costo;
    }

    public Date getPel_fecha_est() {
        return pel_fecha_est;
    }

    public void setPel_fecha_est(Date pel_fecha_est) {
        this.pel_fecha_est = pel_fecha_est;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<ActorPelicula> getActor_peliculas() {
        return actor_peliculas;
    }

    public void setActor_peliculas(List<ActorPelicula> actor_peliculas) {
        this.actor_peliculas = actor_peliculas;
    }

    public List<Alquiler> getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(List<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

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
