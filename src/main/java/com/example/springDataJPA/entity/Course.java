package com.example.springDataJPA.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
    private  long courseId;
    private  String title ;
    private  Integer credit;

    @OneToOne(mappedBy = "course")
    //CouraseMaterial 裡的 attribute  course
    private  CourseMaterial courseMaterial;
}
