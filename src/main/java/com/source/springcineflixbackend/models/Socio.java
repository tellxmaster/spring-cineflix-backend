package com.source.springcineflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "socio")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "soc_cedula")
    @NotEmpty(message = "Es necesario ingresar una cédula valida")
    private String cedula;

    @Column(name = "soc_nombre")
    private String nombre;

    @Column(name = "soc_direccion")
    private String direccion;

    @Column(name = "soc_telefono")
    private String telefono;

    @Column(name = "soc_correo")
    private String correo;

    @Column(name = "updated")
    @UpdateTimestamp
    private LocalDateTime updated;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private List<Alquiler> alquilers;

}
