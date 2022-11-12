package com.example.clinicas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping
public class ClinicasApplication {

    @Autowired
    private IMedicoService service;

    @GetMapping("/Lista")
    public String listar(Model model) {
        List<Medico> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Medico());
        return "form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Medico p, Model model){
        service.save(p);
        return "redirect:/Lista";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Medico>persona=service.ListarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/Lista";
    }

    public static void main(String[] args) {
        SpringApplication.run(ClinicasApplication.class, args);
    }

}
