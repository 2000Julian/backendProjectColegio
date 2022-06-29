package com.colegio.demo.services.Impl;

import com.colegio.demo.entities.Curso;
import com.colegio.demo.repositories.CursoRepository;
import com.colegio.demo.services.CursoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoServices {


    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional
    public List<Curso> obtenerTodos() throws Exception{
        try{
            List<Curso> entities = cursoRepository.findAll();
            return  entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Curso guardarCurso(Curso curso) throws Exception {
        try{
            curso = cursoRepository.save(curso);
            return  curso;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Curso obtenerCursoPorId(Long id) throws  Exception{
        try{
            Optional<Curso> entityOptional = cursoRepository.findById(id);
            return  entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Curso modificarCurso(Long id, Curso entity) throws Exception {
        try{
            Optional<Curso> entityOptional = cursoRepository.findById(id);
            Curso curso = entityOptional.get();
            curso = cursoRepository.save(entity);
            return curso;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminarCurso(Long id) throws Exception {
        try{
            if(cursoRepository.existsById(id)){
                cursoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
