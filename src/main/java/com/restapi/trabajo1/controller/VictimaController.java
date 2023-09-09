package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.Victima;
import com.restapi.trabajo1.services.IVictimaService;
import com.restapi.trabajo1.dao.IVictimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/victima")
public class VictimaController {
    @Autowired
    private IVictimaService vs;

    @Autowired
    private IVictimaRepository vr;

    @GetMapping("/listar")
    public List<Victima> listar(){
        return vs.findAll();
    }

    @GetMapping("/listar/{id}")
    public Victima findById(@PathVariable Long id){
        return vs.findById(id);
    }

    @PostMapping("/save")
    public Victima guardar(@RequestBody Victima e){
        return vs.save(e);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        vs.deleteById(id);
    }

    @GetMapping("/listar/caso/{id}")
    public List<Victima> findByCasoId(@PathVariable Long id){
        return vr.findByCasoId(id);
    }

    @GetMapping("/listar/familia/{id}")
    public List<Victima> findByFamiliaId(@PathVariable Long id){
        return vr.findByFamiliaId(id);
    }

    @GetMapping("/listar/formaasesinato/{id}")
    public List<Victima> findByFormaAsesinatoId(@PathVariable Long id){
        return vr.findByFormaAsesinatoId(id);
    }
}
