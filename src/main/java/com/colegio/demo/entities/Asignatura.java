package com.colegio.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Asignaturas")
public class Asignatura extends Base {

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name="fk_profesor")
    private Profesor profesor;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Estudiante> estudiantes;

    @ManyToOne(optional = false)
    @JoinColumn(name="fk_curso")
    private Curso curso;

}
