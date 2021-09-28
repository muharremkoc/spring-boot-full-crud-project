package com.example.springbootfullcrudproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Encoding;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lessonId;

    String lessonName;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="lesson")
    List<Student> studentList;


    public void addStudent(List<Student> students){

      students.stream().forEach(student -> {
          student.setLesson(this);
      });

      this.studentList=students;

    }
}
