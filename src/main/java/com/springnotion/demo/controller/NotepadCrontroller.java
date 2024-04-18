package com.springnotion.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotepadCrontroller {

    @GetMapping("notepad.html")
    public String viewNotepadPage(Model model){
        return "notepad";
    }
}
