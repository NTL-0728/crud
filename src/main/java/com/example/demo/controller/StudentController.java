package com.example.demo.controller;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public StudentDTO create(@RequestBody StudentDTO dto)
    {
        return studentService.create(dto);
    }
//    @DeleteMapping("/delete/{id}")
//    public void create(@PathVariable("id") String id)
//    {
//        return StudentService.create(dto);
//    }
}

