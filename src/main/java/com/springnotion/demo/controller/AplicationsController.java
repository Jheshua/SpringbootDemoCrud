package com.springnotion.demo.controller;

import com.springnotion.demo.model.Aplications;
import com.springnotion.demo.model.Documents;
import com.springnotion.demo.model.Image;
import com.springnotion.demo.repository.AplicationsRepository;
import com.springnotion.demo.service.AplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AplicationsController {

    @Autowired
    private AplicationsService aplicationsService;

    @Autowired
    private AplicationsRepository aplicationsRepository;

    @GetMapping("aplications.html")
    public String viewAplicationsPage(Model model){
        model.addAttribute("listAplications",aplicationsService.getAllAplications());
        return "aplications";
    }
    @GetMapping("/showMewAplicationForm")
    public String showMewAplicationForm(Model model){
        Aplications aplications = new Aplications();
        model.addAttribute("aplications", aplications);
        return "new_aplication";
    }


    @PostMapping("/saveAplication")
    public String saveAplication(@ModelAttribute("aplication") Aplications aplication){
        aplicationsService.saveAplications(aplication);
        aplication.setDateAdded(new Date()); // Esto establece la fecha actual al momento de guardar la imagen
        aplicationsRepository.save(aplication);
        return "redirect:/aplications.html";
    }

    @GetMapping("/showAplicationsUpdateForm/{id}")
    public String showAplicationsUpdateForm(@PathVariable(value = "id") long id, Model model){
        Aplications aplications = aplicationsService.getAplicationById(id);
        model.addAttribute("aplications", aplications);
        return "update_aplication";
    }

    @GetMapping("/deleteAplications/{id}")
    public String deleteAplications(@PathVariable (value = "id") long id){
        this.aplicationsService.deleteAplicationsById(id);
        return "redirect:/aplications.html";
    }
}
