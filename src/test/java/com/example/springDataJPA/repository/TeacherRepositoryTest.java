package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.Course;
import com.example.springDataJPA.entity.CourseMaterial;
import com.example.springDataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private  TeacherRepository teacherRepository;

    @Test
    public  void  saveTeacher(){

        Course courseA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseB = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .fristName("OHATUV")
                        .lastName("kaha")
                        .courses(List.of(courseA,courseB))
                        .build();
        teacherRepository.save(teacher);
    }
}