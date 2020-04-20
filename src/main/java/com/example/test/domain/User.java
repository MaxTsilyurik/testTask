package com.example.test.domain;







import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public User(String name, String email, String uri, String active) {
        this.name = name;
        this.email = email;
        this.uriFile = uri;
        this.active = active;
    }
}
