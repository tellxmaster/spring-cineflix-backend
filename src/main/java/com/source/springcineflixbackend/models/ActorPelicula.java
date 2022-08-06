package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "actor_pelicula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorPelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="act_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_ACTOR_ACTOR_PELICULA"))
    private Actor actor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pel_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_PELICULA_ACTOR_PELICULA"))
    private Pelicula peliculaAct;

    @Column(name="apl_papel")
    private String apl_papel;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="created_at")
    private Date created_at;

    public void asignarActor(Actor actor) {
        this.actor = actor;
    }

    public void asignarPelicula(Pelicula pelicula) {
        this.peliculaAct = pelicula;
    }

}
