package com.springnotion.demo.controller;

import com.springnotion.demo.model.Aplications;
import com.springnotion.demo.model.Documents;
import com.springnotion.demo.model.Image;
import com.springnotion.demo.repository.DocumentsRepository;
import com.springnotion.demo.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.Document;
import java.util.Date;

@Controller
public class DocumentController {

    @Autowired
    private DocumentsService documentsService;

    @Autowired
    private DocumentsRepository documentsRepository;

    @GetMapping("documents.html")
    public String viewDocumentsPage(Model model){
        model.addAttribute("listDocuments",documentsService.getAllDocuments());
        return "documents";
    }

    @GetMapping("/showMewDocumentForm")
    public String showMewDocumentForm(Model model){
        Documents documents = new Documents();
        model.addAttribute("documents", documents);
        return "new_document";
    }

    @PostMapping("/saveDocument")
    public String saveDocument(@ModelAttribute("document") Documents document){
        documentsService.saveDocuments(document);
        document.setDateAdded(new Date()); // Esto establece la fecha actual al momento de guardar la imagen
        documentsRepository.save(document);
        return "redirect:/documents.html";
    }

    @GetMapping("/showDocumentsUpdateForm/{id}")
    public String showDocumentsUpdateForm(@PathVariable(value = "id") long id, Model model){
        Documents documents = documentsService.getDocumentsById(id);
        model.addAttribute("documents", documents);
        return "update_document";
    }

    @GetMapping("/deleteDocuments/{id}")
    public String deleteDocuments(@PathVariable (value = "id") long id){
        this.documentsService.deleteDocumentsById(id);
        return "redirect:/documents.html";
    }
}
