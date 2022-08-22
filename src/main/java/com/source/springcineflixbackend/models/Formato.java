package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "formato")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Formato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "for_nombre")
    private String for_nombre;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formato")
    private List<Pelicula> peliculas;
}
