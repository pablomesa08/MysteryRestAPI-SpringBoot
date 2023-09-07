package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.models.Caso;
import com.restapi.trabajo1.services.CasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caso")
public class CasoController {
    @Autowired
    private CasoService casoService;

    @GetMapping("/api")
    public String api(){
        return "API: CASO";
    }

    @GetMapping("/caso")
    public List<Caso> findAll(){
        return casoService.getAllCasos();
    }


}
