package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.FormaAsesinato;
import com.restapi.trabajo1.services.IFormaAsesinatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

@RestController
@RequestMapping("/formaasesinato")
public class FormaAsesinatoController {
    @Autowired
    private IFormaAsesinatoService fas;

    @GetMapping("/listar")
    public List<FormaAsesinato> listar(){
        return fas.findAll();
    }

    @GetMapping("/listar/{id}")
    public FormaAsesinato findById(@PathVariable Long id){
        return fas.findById(id);
    }

    @PostMapping("/save")
    public FormaAsesinato guardar(@RequestBody FormaAsesinato e){
        return fas.save(e);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        fas.deleteById(id);
    }

}
