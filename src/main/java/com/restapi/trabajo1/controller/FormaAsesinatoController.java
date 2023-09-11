package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.FormaAsesinato;
import com.restapi.trabajo1.services.IFormaAsesinatoService;
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
@RequestMapping("/formaasesinato")
public class FormaAsesinatoController {
    @Autowired
    private IFormaAsesinatoService fas;

    @GetMapping("/listar")
    public List<FormaAsesinato> listar() {
        return fas.findAll();
    }

//    @GetMapping("/listar/{id}")
//    public FormaAsesinato findById(@PathVariable Long id){
//        return fas.findById(id);
//    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> verFormaAsesinato(@PathVariable Long id) {
        FormaAsesinato formaAsesinato = fas.findById(id);
        Map<String, String> response = new HashMap<>();
        if (formaAsesinato == null) {
            response.put("Mensaje", "La forma de asesinato con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FormaAsesinato>(formaAsesinato, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody FormaAsesinato formaAsesinato, BindingResult result) {
        FormaAsesinato formaAsesinatoNew = null;
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
            formaAsesinatoNew = fas.save(formaAsesinato);
        } catch (Exception e) {
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<FormaAsesinato>(formaAsesinatoNew, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        fas.deleteById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public FormaAsesinato update(@PathVariable Long id, @RequestBody FormaAsesinato formaAsesinato) {
        FormaAsesinato actual = fas.findById(id);
        if (actual != null) {
            actual.setNombre(formaAsesinato.getNombre());
        }
        return fas.save(actual);
    }

}
