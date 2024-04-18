package com.springnotion.demo.service;

import com.springnotion.demo.model.Image;
import com.springnotion.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();

    }

    @Override
    public void saveImage(Image image) {
        this.imageRepository.save(image);
    }

    @Override
    public Image getImageById(long id) {
        Optional<Image> optional = imageRepository.findById(id);
        Image image = null;
        if(optional.isPresent()){
            image = optional.get();
        } else {
            throw  new RuntimeException(" Image not found for ID :: " + id);
        }
        return image;
    }

    @Override
    public void deleteImageById(long id) {
        this.imageRepository.deleteById(id);
    }

}
