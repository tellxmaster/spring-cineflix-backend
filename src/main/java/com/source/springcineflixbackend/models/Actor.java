package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Entity(name = "actor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "act_nombre")
    private String act_nombre;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "sex_id",foreignKey=@ForeignKey(name = "FN_ACTOR_SEXO_PELICULA"))
    @ToString.Exclude
    private Sexo sexo;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "actor")
    private List<ActorPelicula> actores_pelicula;

    public void asignarSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
