package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRpository extends JpaRepository<Course,Long> {

}
