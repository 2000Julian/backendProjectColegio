package com.colegio.demo.controllers;

import com.colegio.demo.entities.Asignatura;
import com.colegio.demo.services.Impl.AsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/asignatura")
public class AsignaturaControler {

    @Autowired
    private AsignaturaServiceImpl asignaturaServiceImpl;


    @GetMapping("")
    public ResponseEntity<?> obtenerTodos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( asignaturaServiceImpl.obtenerTodasLasAsignaturas());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos error al obtener resultados\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( asignaturaServiceImpl.obtenerAsignaturaPorId(id));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos ha ocurrido un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardar( @RequestBody Asignatura entity){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body( asignaturaServiceImpl.guardarAsignatura(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @RequestBody Asignatura entity){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body( asignaturaServiceImpl.modificarAsignatura(id, entity));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body( asignaturaServiceImpl.eliminarAsignatura(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al eliminar el registro\"}");
        }
    }
}
