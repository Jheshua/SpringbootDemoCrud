package com.springnotion.demo.service;


import com.springnotion.demo.model.Aplications;
import com.springnotion.demo.model.Image;
import com.springnotion.demo.repository.AplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicationsServiceImpl implements AplicationsService {

    @Autowired
    private AplicationsRepository aplicationsRepository;

    @Override
    public List<Aplications> getAllAplications() {
        return aplicationsRepository.findAll();
    }

    @Override
    public void saveAplications(Aplications aplications) {
        this.aplicationsRepository.save(aplications);

    }

    @Override
    public Aplications getAplicationById(long id) {
        Optional<Aplications> optional = aplicationsRepository.findById(id);
        Aplications aplications = null;
        if(optional.isPresent()){
            aplications = optional.get();
        } else {
            throw  new RuntimeException(" Aplication not found for ID :: " + id);
        }
        return aplications;
    }

    @Override
    public void deleteAplicationsById(long id) {
        this.aplicationsRepository.deleteById(id);
    }
}
