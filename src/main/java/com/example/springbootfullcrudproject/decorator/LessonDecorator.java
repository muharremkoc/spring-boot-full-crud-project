package com.example.springbootfullcrudproject.decorator;

import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.mapper.LessonMapper;
import com.example.springbootfullcrudproject.model.Lesson;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonDecorator implements LessonMapper {

    @Setter(onMethod = @__({@Autowired}))
    LessonMapper lessonMapper;

    @Override
    public Lesson lessonDTOtoLesson(LessonDTO lessonDTO) {
        Lesson lesson=lessonMapper.lessonDTOtoLesson(lessonDTO);
        Date date = new Date(System.currentTimeMillis());

        lesson.getStudentList().stream().forEach(student -> {
            if(date.getYear()>=student.getBirthday().getYear())
            student.setAge(date.getYear() - student.getBirthday().getYear());
            else student.setBirthday(null);
        });

        return lesson;
    }
}
