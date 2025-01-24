package com.backend.Gestion_Employee.controller;

import com.backend.Gestion_Employee.model.DomaineEmploye;
import com.backend.Gestion_Employee.model.Employe;
import com.backend.Gestion_Employee.repository.EmployeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeController {

    private final EmployeRepository repository;

    @GetMapping("/")
    public String index( Model model){
        model.addAttribute("employés", repository.findAll());
        System.out.println("Employés ajoutés");
        return "index";
    }
    @GetMapping("/employe/nouveau")
    public String nouveau(Model model){
        model.addAttribute("employe" , new Employe());
        model.addAttribute("Domaine" , DomaineEmploye.values());
        if(DomaineEmploye.values().length == 0) System.out.println("tableau vide");
        return "nouvelEmploye";
    }
    @PostMapping("/employe")
    public String enregistreEmploye(@Valid @ModelAttribute("employe") Employe employe , Model model ,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("Domaine" , DomaineEmploye.values());
            return "nouvelEmploye";
        }
        repository.save(employe);
        return "redirect:/";
    }
    @GetMapping("/employe/modifier/{id}")
    public String modifierEmploye(@PathVariable Long id , Model model){
        Employe employe = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Identifiant de l'employé invalide" + id));
        model.addAttribute("employe", employe);
        model.addAttribute("Domaine" , DomaineEmploye.values());
        return "modifEmploye";
    }
    @PostMapping("/employe/{id}")
    public String miseAjourEmploye(@PathVariable Long id, @Valid @ModelAttribute("employe") Employe employe , Model model , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("Domaine" , DomaineEmploye.values());
            return "modifEmploye";
        }
        repository.save(employe);
        return "redirect:/";
    }
    @GetMapping("/employe/supprimer/{id}")
    public String supprimer(@PathVariable Long id , Model model){
        repository.deleteById(id);
        return "redirect:/";
    }
}
