package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.Caso;
import com.restapi.trabajo1.services.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/caso")
public class CasoController {
    @Autowired
    private ICasoService cs;

    @GetMapping("/listar")
    public List<Caso> listar(){
        return cs.findAll();
    }

    @GetMapping("/listar/{id}")
    public Caso findById(@PathVariable Long id){
        return cs.findById(id);
    }

    @PostMapping("/save")
    public Caso guardar(@RequestBody Caso e){
        return cs.save(e);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        cs.deleteById(id);
    }
}
