package com.example.demo.mapper;

import com.example.demo.document.Teacher;
import com.example.demo.dto.TeacherDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface TeacherMapper {

    TeacherDTO toDTO(Teacher source);
}