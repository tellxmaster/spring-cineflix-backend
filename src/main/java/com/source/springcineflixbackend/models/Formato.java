package com.source.springcineflixbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "for_nombre")
    private String for_nombre;

    @OneToMany(mappedBy = "formato")
    private List<Pelicula> peliculas;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="created_at")
    private Date created_at;
}
