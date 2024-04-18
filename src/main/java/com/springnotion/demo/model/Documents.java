package com.springnotion.demo.model;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table (name = "documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "document_name")
    private String name;

    @Column (name = "document_description")
    private String description;

    @Column (name = "document_priority")
    private String priority;

    public String getDocumentData() {
        return documentData;
    }

    public void setDocumentData(String documentData) {
        this.documentData = documentData;
    }

    @Column (name = "document_data")
    private String documentData;

    @Column (name = "document_dateAdded")
    private Date dateAdded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }




    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
