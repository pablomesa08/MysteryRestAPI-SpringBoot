package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.Caso;
import com.restapi.trabajo1.services.ICasoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/caso")
public class CasoController {
    @Autowired
    private ICasoService cs;

    @GetMapping("/listar")
    public List<Caso> listar() {
        return cs.findAll();
    }

//    @GetMapping("/listar/{id}")
//    public Caso findById(@PathVariable Long id){
//
//        return cs.findById(id);
//    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> verCaso(@PathVariable Long id) {
        Caso caso = cs.findById(id);
        Map<String, String> response = new HashMap<>();
        if (caso == null) {
            response.put("Mensaje", "El caso con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Caso>(caso, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Caso caso, BindingResult result) {
        Caso casoNew = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError err : result.getFieldErrors()) {
                errors.add("El campo '" + err.getField() + "' " + err.getDefaultMessage());
            }
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            casoNew = cs.save(caso);
        } catch (Exception e) {
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Caso>(casoNew, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        cs.deleteById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Caso update(@PathVariable Long id, @RequestBody Caso caso) {
        Caso actual = cs.findById(id);
        if (actual != null) {
            actual.setNombre(caso.getNombre());
            actual.setFecha(caso.getFecha());
            actual.setDescripcion(caso.getDescripcion());
        }
        return cs.save(actual);
    }
}
