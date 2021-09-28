package com.example.springbootfullcrudproject.mapper;

import com.example.springbootfullcrudproject.decorator.LessonDecorator;
import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.model.Lesson;
import lombok.experimental.FieldDefaults;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
@DecoratedWith(LessonDecorator.class)
public interface LessonMapper {

    @Mapping(target = "lessonName",source = "lessonName")
    @Mapping(target = "studentList",source = "studentDTOList")
    Lesson lessonDTOtoLesson(LessonDTO lessonDTO);

}
