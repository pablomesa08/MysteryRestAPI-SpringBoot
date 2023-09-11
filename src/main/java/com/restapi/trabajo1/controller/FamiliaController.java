package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.Familia;
import com.restapi.trabajo1.services.IFamiliaService;
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
@RequestMapping("/familia")
public class FamiliaController {
    @Autowired
    private IFamiliaService fs;

    @GetMapping("/listar")
    public List<Familia> listar() {
        return fs.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> verFamilia(@PathVariable Long id) {
        Familia familia = fs.findById(id);
        Map<String, String> response = new HashMap<>();
        if (familia == null) {
            response.put("Mensaje", "La familia con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Familia>(familia, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Familia familia, BindingResult result) {
        Familia familiaNew = null;
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
            familiaNew = fs.save(familia);
        } catch (Exception e) {
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Familia>(familiaNew, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        fs.deleteById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Familia familia(@PathVariable Long id, @RequestBody Familia familia) {
        Familia actual = fs.findById(id);
        if (actual != null) {
            actual.setFortuna(familia.getFortuna());
            actual.setNombre(familia.getNombre());
        }
        return fs.save(actual);
    }

}
