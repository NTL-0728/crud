package com.example.demo.service;

import com.example.demo.document.Teacher;
import com.example.demo.dto.TeacherPayloadDTO;
import com.example.demo.exception.DuplicateFieldNameException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.reponsitory.StudentRepository;
import com.example.demo.reponsitory.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private
    TeacherMapper teacherMapper;


    public void create(TeacherPayloadDTO dto) {
        if (teacherRepository.existsByName(dto.getName())) {
            throw new DuplicateFieldNameException(Teacher.class, dto.getName());
        }
        Teacher teacher = new Teacher();
        teacherMapper.updateTeacher(dto, teacher);
        teacherRepository.save(teacher);
    }

    public void update(TeacherPayloadDTO dto, String id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Teacher.class, id));
        teacherMapper.updateTeacher(dto, teacher);
        teacherRepository.save(teacher);
    }

    public TeacherPayloadDTO findById(String id) {
        return teacherRepository.findById(id).map(teacherMapper::toDTO).orElseThrow(() -> new ResourceNotFoundException(Teacher.class, id));
    }
}
