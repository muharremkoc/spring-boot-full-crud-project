package com.example.springbootfullcrudproject.dto;


import com.example.springbootfullcrudproject.model.Student;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {


    String lessonName;

    List<Student> studentDTOList;

}
