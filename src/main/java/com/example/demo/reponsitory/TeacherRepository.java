package com.example.demo.reponsitory;

import com.example.demo.document.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    boolean existsByName(String name);

}