package com.source.springcineflixbackend.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;

@Entity(name = "actor_pelicula")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class ActorPelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //@JsonIgnore
    @Column(name="apl_papel")
    private String apl_papel;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;


    @ManyToOne
    @JoinColumn(name="act_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_ACTOR_ACTOR_PELICULA"))
    @ToString.Exclude
    private Actor actor;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pel_id", referencedColumnName = "id", foreignKey=@ForeignKey(name = "FN_PELICULA_ACTOR_PELICULA"))
    @ToString.Exclude
    private Pelicula peliculaAct;

    public void asignarActor(Actor actor) {
        this.actor = actor;
    }

    public void asignarPelicula(Pelicula pelicula) {
        this.peliculaAct = pelicula;
    }

}
