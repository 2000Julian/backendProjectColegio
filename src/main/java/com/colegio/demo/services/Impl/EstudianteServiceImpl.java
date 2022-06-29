package com.colegio.demo.services.Impl;

import com.colegio.demo.entities.Estudiante;
import com.colegio.demo.repositories.EstudianteRepository;
import com.colegio.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    @Transactional
    public List<Estudiante> obtenerTodos() throws Exception{
        try{
            List<Estudiante> entities = estudianteRepository.findAll();
            return  entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante guardarEstudiante(Estudiante estudiante) throws Exception {
        try{
            estudiante = estudianteRepository.save(estudiante);
            return  estudiante;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante obtenerEstudiantePorId(Long id) throws  Exception{
        try{
            Optional<Estudiante> entityOptional = estudianteRepository.findById(id);
            return  entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudiante estudianteAModificar(Long id, Estudiante entity) throws Exception {
        try{
            Optional<Estudiante> entityOptional = estudianteRepository.findById(id);
            Estudiante estudiante = entityOptional.get();
            estudiante = estudianteRepository.save(entity);
            return estudiante;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminarEstudiante(Long id) throws Exception {
        try{
            if(estudianteRepository.existsById(id)){
                estudianteRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
