package com.springnotion.demo.service;

import com.springnotion.demo.model.Documents;

import javax.swing.text.Document;
import java.util.List;

public interface DocumentsService {
    List<Documents> getAllDocuments();
    void saveDocuments(Documents documents);
    Documents getDocumentsById(long id);
    void deleteDocumentsById(long id);
}
