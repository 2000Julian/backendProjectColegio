package com.colegio.demo.controllers;

import com.colegio.demo.entities.Curso;
import com.colegio.demo.services.Impl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/curso")
public class CursoControler {
    @Autowired
    private CursoServiceImpl cursoServiceImpl;


    @GetMapping("")
    public ResponseEntity<?> obtenerTodos(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( cursoServiceImpl.obtenerTodos());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos error al obtener resultados\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body( cursoServiceImpl.obtenerCursoPorId(id));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lo sentimos ha ocurrido un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardar( @RequestBody Curso entity){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body( cursoServiceImpl.guardarCurso(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @RequestBody Curso entity){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body( cursoServiceImpl.modificarCurso(id, entity));
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al guardar la información\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body( cursoServiceImpl.eliminarCurso(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Lo sentimos ha ocurrido un error al eliminar el registro\"}");
        }
    }
}
