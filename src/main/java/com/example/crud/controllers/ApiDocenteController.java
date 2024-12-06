package com.example.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dto.Docente;
import com.example.crud.services.DocenteService;

@RequestMapping
@RestController
public class ApiDocenteController {

    @Autowired
    private DocenteService docenteService;

    
    @GetMapping("/api/docentes")
    public List<Docente> apiDocentes() {
        List<Docente> docentes = docenteService.getDocentes();
        return docentes;
    }

}
