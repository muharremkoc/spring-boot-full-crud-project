package com.example.springbootfullcrudproject.service.student;

import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.model.Student;

public interface StudentService {
    
    Student createStudent(int id, Student student);

    void  deleteStudent(int id);

    Student updateStudent(int id,Student student);
}
