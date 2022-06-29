package com.colegio.demo.services.Impl;

import com.colegio.demo.entities.Asignatura;
import com.colegio.demo.repositories.AsignaturaRepository;
import com.colegio.demo.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional
    public List<Asignatura> obtenerTodasLasAsignaturas() throws Exception{
        try{
            List<Asignatura> entities = asignaturaRepository.findAll();
            return  entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Asignatura guardarAsignatura(Asignatura asignatura) throws Exception {
        try{
            asignatura = asignaturaRepository.save(asignatura);
            return  asignatura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Asignatura obtenerAsignaturaPorId(Long id) throws  Exception{
        try{
            Optional<Asignatura> entityOptional = asignaturaRepository.findById(id);
            return  entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Asignatura modificarAsignatura(Long id, Asignatura entity) throws Exception {
        try{
            Optional<Asignatura> entityOptional = asignaturaRepository.findById(id);
            Asignatura asignatura = entityOptional.get();
            asignatura = asignaturaRepository.save(entity);
            return asignatura;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public boolean eliminarAsignatura(Long id) throws Exception {
        try{
            if(asignaturaRepository.existsById(id)){
                asignaturaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
           throw new Exception(e.getMessage());
        }
    }


}
