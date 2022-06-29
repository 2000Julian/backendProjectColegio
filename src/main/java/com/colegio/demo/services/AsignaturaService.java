package com.colegio.demo.services;

import com.colegio.demo.entities.Asignatura;

import java.util.List;

public interface AsignaturaService {

    public List<Asignatura> obtenerTodasLasAsignaturas() throws Exception;
    public Asignatura guardarAsignatura(Asignatura asignatura) throws Exception;

    public Asignatura obtenerAsignaturaPorId(Long id) throws Exception;

    public Asignatura modificarAsignatura(Long id, Asignatura asignatura) throws Exception;

    public boolean eliminarAsignatura(Long id) throws Exception;



}
