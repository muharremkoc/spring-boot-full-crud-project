package com.example.springbootfullcrudproject.controller;

import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.model.Lesson;
import com.example.springbootfullcrudproject.service.lesson.LessonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/fullcrud")
public class LessonController {

    final LessonService lessonService;

    @PostMapping(value = "/student")
    public Lesson saveStudents(@RequestBody LessonDTO lessonDTO){
        return lessonService.saveLesson(lessonDTO);
    }

    @GetMapping(value = "/students/{lessonId}")
    public Optional<Lesson> studentList(@PathVariable("lessonId") int lessonId){
        return lessonService.getStudents(lessonId);
    }

    @DeleteMapping(value = "/students/{lessonId}")
    public void deleteLesson(@PathVariable("lessonId") int lessonId){
         lessonService.deleteStudents(lessonId);
    }
}
