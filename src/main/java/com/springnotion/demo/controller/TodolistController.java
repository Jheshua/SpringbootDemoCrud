package com.springnotion.demo.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodolistController {

    @GetMapping("todolist.html")
    public String viewTodolistPage(Model model){

        return "todolist";
    }
}
