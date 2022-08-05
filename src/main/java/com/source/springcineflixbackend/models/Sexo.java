package com.source.springcineflixbackend.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sexo")
@NoArgsConstructor
@AllArgsConstructor
public class Sexo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sex_nombre")
    private String sex_nombre;

    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "created_at")
    private Date created_at;

    @OneToMany(mappedBy = "sexo")
    private List<Actor> actors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex_nombre() {
        return sex_nombre;
    }

    public void setSex_nombre(String sex_nombre) {
        this.sex_nombre = sex_nombre;
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

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActors(Actor actor){
        if(actors==null) actors = new ArrayList<Actor>();
        actors.add(actor);
        actor.setSexo(this);
    }
}
