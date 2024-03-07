package com.example.demo.service;

import com.example.demo.document.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.reponsitory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public void create(StudentDTO dto) {
        Student student = new Student();
        studentMapper.updateStudent(dto, student);
        studentRepository.save(student);
    }

    public void update(StudentDTO dto, String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Student.class, id));
        studentMapper.updateStudent(dto, student);
        studentRepository.save(student);
    }

    public StudentDTO findById(String id) {
        return studentRepository.findById(id).map(studentMapper::toDTO).orElseThrow(() -> new ResourceNotFoundException(Student.class, id));
    }
}
