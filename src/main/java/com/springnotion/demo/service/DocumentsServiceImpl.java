package com.springnotion.demo.service;

import com.springnotion.demo.model.Documents;
import com.springnotion.demo.model.Image;
import com.springnotion.demo.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentsServiceImpl implements DocumentsService{

    @Autowired
    private DocumentsRepository documentsRepository;


    @Override
    public List<Documents> getAllDocuments() {
        return documentsRepository.findAll();

    }

    @Override
    public void saveDocuments(Documents documents) {
        this.documentsRepository.save(documents);
    }

    @Override
    public Documents getDocumentsById(long id) {
        Optional<Documents> optional = documentsRepository.findById(id);
        Documents documents = null;
        if(optional.isPresent()){
            documents = optional.get();
        } else {
            throw  new RuntimeException(" document not found for ID :: " + id);
        }
        return documents;
    }

    @Override
    public void deleteDocumentsById(long id) {
        this.documentsRepository.deleteById(id);
    }
}
