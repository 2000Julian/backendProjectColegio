package com.colegio.demo.services;

import com.colegio.demo.entities.Curso;

import java.util.List;

public interface CursoServices {

    public List<Curso> obtenerTodos() throws Exception;

    public Curso guardarCurso(Curso curso) throws Exception;

    public Curso obtenerCursoPorId(Long idCurso) throws Exception;

    public Curso modificarCurso(Long id, Curso curso) throws Exception;

    public boolean eliminarCurso(Long id) throws Exception;
}
