package com.example.springbootfullcrudproject.service.lesson;

import com.example.springbootfullcrudproject.decorator.LessonDecorator;
import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.model.Lesson;
import com.example.springbootfullcrudproject.model.Student;
import com.example.springbootfullcrudproject.repository.LessonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{

   final LessonRepository lessonRepository;

   final LessonDecorator lessonDecorator;


    @Override
    public Lesson saveLesson(LessonDTO lessonDTO) {


        Lesson lesson=lessonDecorator.lessonDTOtoLesson(lessonDTO);

        List<Student> studentList=lesson.getStudentList();
        lesson.addStudent(studentList);


          return lessonRepository.save(lesson);
    }

    @Override
    public Optional<Lesson> getStudents(int lessonId) {

        return  lessonRepository.findById(lessonId);
    }
    @Override
      public void deleteStudents(int lessonId){
         lessonRepository.deleteById(lessonId);
      }



}
