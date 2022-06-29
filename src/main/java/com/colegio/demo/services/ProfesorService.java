package com.colegio.demo.services;

import com.colegio.demo.entities.Profesor;

import java.util.List;

public interface ProfesorService {

    public List<Profesor> obtenerTodos() throws Exception;

    public Profesor guardarProfesor(Profesor profesor) throws  Exception;

    public Profesor obtenerProfesorPorId(Long idProfesor) throws Exception;

    public Profesor profesorAModificar(Long id, Profesor profesor) throws Exception;

    public boolean eliminarProfesor(Long id) throws Exception;
}
