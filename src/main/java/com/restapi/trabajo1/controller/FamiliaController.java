package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.Familia;
import com.restapi.trabajo1.services.IFamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {
    @Autowired
    private IFamiliaService fs;

    @GetMapping("/listar")
    public List<Familia> listar(){
        return fs.findAll();
    }

    @GetMapping("/listar/{id}")
    public Familia findById(@PathVariable Long id){
        return fs.findById(id);
    }

    @PostMapping("/save")
    public Familia guardar(@RequestBody Familia e){
        return fs.save(e);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        fs.deleteById(id);
    }
}
