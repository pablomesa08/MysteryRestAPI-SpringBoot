package com.restapi.trabajo1.controller;

import com.restapi.trabajo1.services.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familia")
public class FamiliaController {
    @Autowired
    private FamiliaService familiaService;

    @GetMapping("/api")
    public String api(){
        return "API: FAMILIA";
    }

    @GetMapping("/familia")
    public String findAll(){
        return familiaService.getAllFamilias().toString();
    }
}
