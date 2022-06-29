package com.colegio.demo.services.Impl;

import com.colegio.demo.entities.Profesor;
import com.colegio.demo.repositories.ProfesorRepository;
import com.colegio.demo.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {


    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    @Transactional
    public List<Profesor> obtenerTodos() throws Exception{
        try{
            List<Profesor> entities = profesorRepository.findAll();
            return  entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Profesor guardarProfesor(Profesor profesor) throws Exception {
        try{
            profesor = profesorRepository.save(profesor);
            return  profesor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Profesor obtenerProfesorPorId(Long id) throws  Exception{
        try{
            Optional<Profesor> entityOptional = profesorRepository.findById(id);
            return  entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Profesor profesorAModificar(Long id, Profesor entity) throws Exception {
        try{
            Optional<Profesor> entityOptional = profesorRepository.findById(id);
            Profesor profesor = entityOptional.get();
            profesor = profesorRepository.save(entity);
            return profesor;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminarProfesor(Long id) throws Exception {
        try{
            if(profesorRepository.existsById(id)){
                profesorRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
