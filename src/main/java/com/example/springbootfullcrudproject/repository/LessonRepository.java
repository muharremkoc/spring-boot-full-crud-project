package com.example.springbootfullcrudproject.repository;

import com.example.springbootfullcrudproject.model.Lesson;
import com.example.springbootfullcrudproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {

}
