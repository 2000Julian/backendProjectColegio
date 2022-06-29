package com.colegio.demo.services.Impl;

import com.colegio.demo.entities.Colegio;
import com.colegio.demo.repositories.ColegioRepository;
import com.colegio.demo.services.ColegioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ColegioServiceImpl implements ColegioServices {

    @Autowired
    private ColegioRepository colegioRepository;

    @Override
    @Transactional
    public List<Colegio> obtenerTodos() throws Exception{
        try{
            List<Colegio> entities = colegioRepository.findAll();
            return  entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Colegio guardarColegio(Colegio colegio) throws Exception {
        try{
            colegio = colegioRepository.save(colegio);
            return  colegio;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Colegio buscarColegioPorId(Long id) throws  Exception{
        try{
            Optional<Colegio> entityOptional = colegioRepository.findById(id);
            return  entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Colegio modificarColegio(Long id, Colegio entity) throws Exception {
        try{
            Optional<Colegio> entityOptional = colegioRepository.findById(id);
            Colegio colegio = entityOptional.get();
            colegio = colegioRepository.save(entity);
            return colegio;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminarColegio(Long id) throws Exception {
        try{
            if(colegioRepository.existsById(id)){
                colegioRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
