package com.example.demo.service;

import com.example.demo.document.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.reponsitory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired private StudentRepository StudentRepository;
    @Autowired private
    StudentMapper StudentMapper;

    public StudentDTO   create(StudentDTO dto) {
        Student Student = new Student();
        Student.setId(dto.getId());
        Student.setName(dto.getName());
        return StudentMapper.toDTO(StudentRepository.save(Student));
    }


}
