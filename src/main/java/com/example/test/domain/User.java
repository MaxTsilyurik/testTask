package com.example.test.domain;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;

    private String email;

    private String active;

    private String uriFile;

    @Column(nullable = true)
    @CreationTimestamp
    private Timestamp timestamp;

    public User(String name, String email, String uriFile,
                String active) {
        this.name = name;
        this.uriFile = uriFile;
        this.email = email;
        this.active = active;
    }

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getUriFile() {
        return uriFile;
    }

    public void setUriFile(String uriFile) {
        this.uriFile = uriFile;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
