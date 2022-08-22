package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "sexo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Sexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sex_nombre")
    private String sex_nombre;

    @Column(name = "updated")
    @UpdateTimestamp
    private Date updated;

    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexo")
    private List<Actor> actors;

}
