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
//@Table name: Table的name對映到資料庫中的資料表名稱
//@UniqueConstraint
@Table(name = "tbl_student",
        //表的唯一约束
        uniqueConstraints  = @UniqueConstraint(
                                name =  "emailid_unique",
                                columnNames = "amail_address"
        )
)
public class Student {

    //setting primary key
    @Id
    //@GeneratedValue和@SequenceGenerator是JPA标准注解，GeneratedValue用来定义主键生成策略，SequenceGenerator用来定义一个生成主键的序列；它们要联合使用才有效
    //sequenceName - 表示生成策略用到的数据库序列名称。
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    //allocationSize - 每次主键值增加的大小，例如设置成1，
    //@GeneratedValue 指定 ID 的生成方式。
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "student_sequence"
            //generator 對應到@SequenceGenerator的name
    )
    private Long studentId ;
    private  String firstName;
    private  String lastName;
    //@Column name: 對應到Table的欄位中的欄位名稱
    //nullable 可否為null
    @Column(name = "email_address",nullable = false)
    private  String emailId;
    //不想創建Entity但又想放進同一個Table
    @Embedded
    private  Guardian guardian;





}
