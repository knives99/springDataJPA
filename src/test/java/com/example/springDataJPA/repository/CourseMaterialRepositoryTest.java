package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.Course;
import com.example.springDataJPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private  CourseMaterialRepository repository;

    @Test
    public  void  SaveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("wwwww")
                .course(course)
                .build();
        repository.save(courseMaterial);
    }
}