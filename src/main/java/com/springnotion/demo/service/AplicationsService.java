package com.springnotion.demo.service;

import com.springnotion.demo.model.Aplications;

import java.util.List;

public interface AplicationsService {

    List<Aplications> getAllAplications();
    void saveAplications(Aplications aplications);
    Aplications getAplicationById(long id);
    void deleteAplicationsById(long id);
}
