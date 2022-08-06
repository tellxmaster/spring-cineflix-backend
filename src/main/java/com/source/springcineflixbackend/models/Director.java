package com.source.springcineflixbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "director")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="dir_nombre")
    private String dir_nombre;

    @OneToMany(mappedBy = "director")
    private List<Pelicula> peliculas;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="created_at")
    private Date created_at;
}
