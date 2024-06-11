package com.projetopoobackend.sistemadeestoque.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class UserRole {

    @Id
    private String id;
    private String name;

    public UserRole() {}

    public UserRole(String name) {
        this.name = name;
    }

    public UserRole(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}