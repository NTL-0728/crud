package com.example.demo.service;

import com.example.demo.document.Student;
import com.example.demo.document.Teacher;
import com.example.demo.dto.TeacherDTO;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.reponsitory.StudentRepository;
import com.example.demo.reponsitory.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired private
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired private
    TeacherMapper teacherMapper;


    public TeacherDTO create(TeacherDTO dto)
    {
        // name không được trùng
        if(teacherRepository.existsByName(dto.getName()))
        {
            throw  new RuntimeException();
        }
        teacherRepository.existsByName(dto.getName());
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());

        return  teacherMapper.toDTO(teacherRepository.save(teacher));
    }
    private Teacher getById(String id)
    {
        return teacherRepository.findById(id).orElse(null);
    }
    public  void deleteById(String id)
    {
        Teacher teacher = getById(id);
//        getById(id) -> hàm tìm theo Id
        if(teacher != null)
        {
//             kiểm tra Gv đã có chủ nhiệm HS nào không
            Student student = studentRepository.findByTeacherName(teacher.getName()).orElse(null);
            if(student == null)
            {
                //nếu trong Table Student có tên Teacher -> không được xóa.
//                Xóa teacher
                teacherRepository.delete(teacher);
            }
        }
    }
}
