package com.example.demo.document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document("teacher")
public class Teacher {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private String className;
    private String email;
}
