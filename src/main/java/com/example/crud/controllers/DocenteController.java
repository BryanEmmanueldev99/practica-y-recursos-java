package com.example.crud.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.crud.dto.Docente;
import com.example.crud.interfaces.IDocente;
import com.example.crud.services.DocenteService;


@Controller
@RequestMapping
public class DocenteController {

        @Autowired
        private DocenteService docenteService;
        @Autowired
        private IDocente iDocente;


          @GetMapping("/docentes")
          public String RecuperarDocentes(Model model) 
          {
               List<Docente> docentes = docenteService.getDocentes();
               model.addAttribute("docentes", docentes);
               return "index";
          }

          @GetMapping("/docentes/store") 
          public String save(Model model)
          {
              model.addAttribute("docente", new Docente());
              return "create";
          }

          // @PostMapping("/docentes") 
          // public String store(@Valid Docente d, Model model)
          // {
          //      docenteService.storeDocente(d);
          //      return "redirect:/docentes";
          
          @PostMapping("/docentes") 
          public String store(@Valid Docente d, Model model)
          {
               docenteService.optinal_store(d);
               return "redirect:/docentes";
          }


          @GetMapping("/docentes/{id}")
          public String updateView(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes)
          {
               // Optional<Docente> docente = docenteService.getIdDocente(id);
               // model.addAttribute("docente", docente);
               Docente docente = iDocente.findById(id).get();
               model.addAttribute("docente", docente); 
               return "update";
          }

          @PostMapping("/docentes/{id}")
          public String updateDocenteId(@PathVariable("id") long id, Docente docente, Model model)
          {
               docenteService.UpdateDocente(id, docente);
               return "redirect:/docentes";
          }

          @PostMapping("/borrar-docente/{id}")
          public String destroyDocente(@PathVariable("id") long id)
          {
               docenteService.deleteDocente(id);
               return "redirect:/docentes";
          }

}
