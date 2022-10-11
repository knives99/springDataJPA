package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRpositoryTest {

    @Autowired
    private  CourseRpository courseRpository;

    public  void printCourse(){
        List<Course> courses = courseRpository.findAll();

        System.out.println(courses);
    }
}