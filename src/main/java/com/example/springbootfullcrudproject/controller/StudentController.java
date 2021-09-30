package com.example.springbootfullcrudproject.controller;

import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.model.Student;
import com.example.springbootfullcrudproject.service.student.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/std")
@RequiredArgsConstructor
public class StudentController {

    final StudentService studentService;

    @PostMapping("/student")
    public Student createStudent(@RequestParam int id, @RequestBody Student student){
        return studentService.createStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }


    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id")int id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

}
