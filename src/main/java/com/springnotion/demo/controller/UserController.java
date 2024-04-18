package com.springnotion.demo.controller;

import com.springnotion.demo.dto.UserDto;
import com.springnotion.demo.repository.AplicationsRepository;
import com.springnotion.demo.repository.DocumentsRepository;
import com.springnotion.demo.repository.ImageRepository;
import com.springnotion.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private DocumentsRepository documentsRepository;

	@Autowired
	private AplicationsRepository aplicationsRepository;



	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}

	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("index2.html")
	public String userPage (Model model, Principal principal) {
		model.addAttribute("countImage", imageRepository.count());
		model.addAttribute("countDocuments", documentsRepository.count());
		model.addAttribute("countAplications", aplicationsRepository.count());
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "index2.html";
	}

	@GetMapping("index.html")
	public String adminPage (Model model, Principal principal) {
		model.addAttribute("countImage", imageRepository.count());
		model.addAttribute("countDocuments", documentsRepository.count());
		model.addAttribute("countAplications", aplicationsRepository.count());
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "index";
	}




}




