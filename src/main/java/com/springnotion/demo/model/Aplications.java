package com.springnotion.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "aplications")
public class Aplications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "aplication_name")
    private String name;

    @Column(name = "aplication_description")
    private String description;

    @Column(name = "aplication_size")
    private String size;

    @Column(name = "aplication_data")
    private byte[] aplicationData;

    @Column(name = "aplication_dateAdded")
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public byte[] getAplicationData() {
        return aplicationData;
    }

    public void setAplicationData(byte[] aplicationData) {
        this.aplicationData = aplicationData;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
