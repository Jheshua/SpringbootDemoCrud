package com.springnotion.demo.controller;

import com.springnotion.demo.model.Image;
import com.springnotion.demo.repository.ImageRepository;
import com.springnotion.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;


    @Autowired
    private ImageRepository imageRepository;


    //display list of images
    @GetMapping("images.html")
    public String viewHomePage(Model model){
        model.addAttribute("listImages", imageService.getAllImages());
        return "images";
    }

    @GetMapping("/showMewImageForm")
    public String showMewImageForm(Model model) {
        Image image = new Image();
        model.addAttribute("image", image);
        return "new_image";

    }
    @PostMapping("/saveImage")
    public String saveImage(@ModelAttribute("image") Image image){
        imageService.saveImage(image);
        image.setDateAdded(new Date()); // Esto establece la fecha actual al momento de guardar la imagen
        imageRepository.save(image);
        return "redirect:/images.html";
    }

    @GetMapping("/showImagesUpdateForm/{id}")
    public String showImagesUpdateForm(@PathVariable (value = "id") long id, Model model){
        Image image = imageService.getImageById(id);
        model.addAttribute("image", image);
        return "update_image";
    }

    @GetMapping("/deleteImage/{id}")
    public String deleteImage(@PathVariable (value = "id") long id){
        this.imageService.deleteImageById(id);
        return "redirect:/images.html";
    }
}
