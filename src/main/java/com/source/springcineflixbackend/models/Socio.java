package com.source.springcineflixbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "socio")
    private List<Alquiler> alquilers;

    @Column(name="updated_at")
    private LocalDateTime updated_at;

    @Column(name="created_at")
    private LocalDateTime created_at;
}
