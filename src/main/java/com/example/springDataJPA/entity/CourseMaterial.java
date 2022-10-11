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
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_sequence",sequenceName = "course_material_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_material_sequence")
    private  Long courseMaterialId;
    private  String url;

    //都有設定cascade為CascadeType.ALL，這表示儲存其中一方實例時，若有參考至另一方實例，另一方實例也一併儲存，這個稱之為聯級（Cascade）操作。
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
    //@Join@JoinColumn(name="對應database column",referencedColumnName ="對應attribute" )
    @JoinColumn(name="couse_id",referencedColumnName ="courseId" )
    private  Course course;
}
