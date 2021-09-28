package com.example.springbootfullcrudproject.service;

import com.example.springbootfullcrudproject.dto.LessonDTO;
import com.example.springbootfullcrudproject.model.Lesson;

import java.util.Optional;

public interface LessonService {
    Lesson saveLesson(LessonDTO lessonDTO);

    Optional<Lesson> getStudents(int lessonId);

    void deleteStudents(int lessonId);
}
