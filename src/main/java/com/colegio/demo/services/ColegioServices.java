package com.colegio.demo.services;

import com.colegio.demo.entities.Colegio;

import java.util.List;


public interface ColegioServices {

    public List<Colegio> obtenerTodos() throws Exception;

    public Colegio guardarColegio(Colegio colegio) throws Exception;

    public Colegio buscarColegioPorId(Long id) throws Exception;

    public Colegio modificarColegio(Long id, Colegio colegio) throws Exception;

    public boolean eliminarColegio( Long id ) throws Exception;
}
