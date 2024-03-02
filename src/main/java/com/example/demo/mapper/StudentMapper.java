package com.example.demo.mapper;

import com.example.demo.document.Student;
import com.example.demo.dto.StudentDTO;
import org.mapstruct.*;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDTO(Student source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudent(StudentDTO source, @MappingTarget Student target);
}
