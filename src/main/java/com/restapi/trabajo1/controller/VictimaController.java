package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.dao.IVictimaRepository;
import com.restapi.trabajo1.models.Victima;
import com.restapi.trabajo1.services.IVictimaService;
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
@RequestMapping("/victima")
public class VictimaController {
    @Autowired
    private IVictimaService vs;

    @Autowired
    private IVictimaRepository vr;

    @GetMapping("/listar")
    public List<Victima> listar() {
        return vs.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> verVictima(@PathVariable Long id) {
        Victima victima = vs.findById(id);
        Map<String, String> response = new HashMap<>();
        if (victima == null) {
            response.put("Mensaje", "La victima con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Victima>(victima, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Victima victima, BindingResult result) {
        Victima victimaNew = null;
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
            victimaNew = vs.save(victima);
        } catch (Exception e) {
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Victima>(victimaNew, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        vs.deleteById(id);
    }

    @GetMapping("/listar/caso/{id}")
    public ResponseEntity<?> verVictimaByCasoId(@PathVariable Long id) {
        List<Victima> victima = vr.findByCasoId(id);
        Map<String, String> response = new HashMap<>();
        if (victima.isEmpty()) {
            response.put("Mensaje", "La victima con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Victima>>(victima, HttpStatus.OK);
    }

    @GetMapping("/listar/familia/{id}")
    public ResponseEntity<?> verVictimaByFamiliaId(@PathVariable Long id) {
        List<Victima> victima = vr.findByFamiliaId(id);
        Map<String, String> response = new HashMap<>();
        if (victima.isEmpty()) {
            response.put("Mensaje", "La victima con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Victima>>(victima, HttpStatus.OK);
    }

    @GetMapping("/listar/formaasesinato/{id}")
    public ResponseEntity<?> verVictimaByFormaAsesinatoId(@PathVariable Long id) {
        List<Victima> victima = vr.findByFormaAsesinatoId(id);
        Map<String, String> response = new HashMap<>();
        if (victima.isEmpty()) {
            response.put("Mensaje", "La victima con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Victima>>(victima, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Victima update(@PathVariable Long id, @RequestBody Victima victima) {
        Victima actual = vs.findById(id);

        if (actual != null) {
            actual.setLugarMuerte(victima.getLugarMuerte());
            actual.setNombre(victima.getNombre());
            actual.setFechaMuerte(victima.getFechaMuerte());
            actual.setCaso(victima.getCaso());
            actual.setFamilia(victima.getFamilia());
            actual.setFormaAsesinato(victima.getFormaAsesinato());
            actual.setFechaMuerte(victima.getFechaMuerte());
            actual.setOcupacion(victima.getOcupacion());
            actual.setSexo(victima.getSexo());
            actual.setEdad(victima.getEdad());
        }
        return vs.save(actual);
    }
}
