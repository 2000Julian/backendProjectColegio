package com.colegio.demo.services;

import com.colegio.demo.entities.Estudiante;

import java.util.List;


public interface EstudianteService {

    public List<Estudiante> obtenerTodos() throws Exception;

    public Estudiante guardarEstudiante(Estudiante estudiante) throws Exception;

    public Estudiante obtenerEstudiantePorId(Long idEstudiante) throws Exception;

    public Estudiante estudianteAModificar(Long id, Estudiante estudiante) throws Exception;

    public boolean eliminarEstudiante(Long id) throws Exception;
}
