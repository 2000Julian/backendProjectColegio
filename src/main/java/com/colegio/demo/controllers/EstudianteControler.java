package com.colegio.demo.controllers;

import com.colegio.demo.entities.Estudiante;
import com.colegio.demo.services.Impl.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/estudiante")
public class EstudianteControler {
    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;


    @GetMapping("")
    public ResponseEntity<?> obtenerTodos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( estudianteServiceImpl.obtenerTodos());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos error al obtener resultados\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( estudianteServiceImpl.obtenerEstudiantePorId(id));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos ha ocurrido un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardar( @RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body( estudianteServiceImpl.guardarEstudiante(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @RequestBody Estudiante entity){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body( estudianteServiceImpl.estudianteAModificar(id, entity));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body( estudianteServiceImpl.eliminarEstudiante(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al eliminar el registro\"}");
        }
    }
}
