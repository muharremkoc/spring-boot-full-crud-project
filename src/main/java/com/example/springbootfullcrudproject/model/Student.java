package com.example.springbootfullcrudproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studentNumber;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;


    Date birthday;

    @Column(name = "age")
    @JsonIgnore
   int age;


    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Lesson lesson;

}
