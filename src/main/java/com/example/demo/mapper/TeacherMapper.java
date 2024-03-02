package com.example.demo.mapper;

import com.example.demo.document.Teacher;
import com.example.demo.dto.TeacherPayloadDTO;
import org.mapstruct.*;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface TeacherMapper {

    TeacherPayloadDTO toDTO(Teacher source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTeacher(TeacherPayloadDTO source, @MappingTarget Teacher target);
}