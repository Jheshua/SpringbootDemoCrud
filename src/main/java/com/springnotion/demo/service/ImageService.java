package com.springnotion.demo.service;

import com.springnotion.demo.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();
    void saveImage(Image image);
    Image getImageById(long id);
    void deleteImageById(long id);
}
