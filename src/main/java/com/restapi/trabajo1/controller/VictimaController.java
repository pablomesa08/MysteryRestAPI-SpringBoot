package com.restapi.trabajo1.controller;


import com.restapi.trabajo1.services.VictimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/victima")

public class VictimaController {
    private VictimaService victimaService;

    @GetMapping("/api")
    public String api(){
        return "API: victima";
    }

    @GetMapping("/victima")
    public String findAll(){
        return victimaService.getAllVictimas().toString();
    }
}
