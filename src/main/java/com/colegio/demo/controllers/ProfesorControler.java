package com.colegio.demo.controllers;

import com.colegio.demo.entities.Profesor;
import com.colegio.demo.services.Impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/profesor")
public class ProfesorControler {

    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;


    @GetMapping("")
    public ResponseEntity<?> obtenerTodos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( profesorServiceImpl.obtenerTodos());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos error al obtener resultados\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( profesorServiceImpl.obtenerProfesorPorId(id));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos ha ocurrido un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardar( @RequestBody Profesor entity){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body( profesorServiceImpl.guardarProfesor(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @RequestBody Profesor entity){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body( profesorServiceImpl.profesorAModificar(id, entity));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body( profesorServiceImpl.eliminarProfesor(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al eliminar el registro\"}");
        }
    }
}
