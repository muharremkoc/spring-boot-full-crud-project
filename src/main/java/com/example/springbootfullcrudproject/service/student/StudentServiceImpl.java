package com.example.springbootfullcrudproject.service.student;

import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.mapper.LessonMapper;
import com.example.springbootfullcrudproject.model.Lesson;
import com.example.springbootfullcrudproject.model.Student;
import com.example.springbootfullcrudproject.repository.LessonRepository;
import com.example.springbootfullcrudproject.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {

    final StudentRepository studentRepository;

    final LessonRepository lessonRepository;




    @Override
    public Student createStudent(int id, Student student) {



        Lesson lesson=lessonRepository.findById(id).get();

        Date date = new Date(System.currentTimeMillis());

        student.setLesson(lesson);

        if(date.getYear()>=student.getBirthday().getYear())
            student.setAge(date.getYear() - student.getBirthday().getYear());
        else student.setBirthday(null);


        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
         studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {

        Student newStudent=studentRepository.findById(id).get();
        Lesson lesson=lessonRepository.findById(id).get();

        Date date = new Date(System.currentTimeMillis());

        student.setLesson(lesson);

        if(date.getYear()>=student.getBirthday().getYear())
            newStudent.setAge(date.getYear() - student.getBirthday().getYear());
        else student.setBirthday(null);

        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setBirthday(student.getBirthday());
        newStudent.setLesson(lesson);

        return newStudent;
    }


}
