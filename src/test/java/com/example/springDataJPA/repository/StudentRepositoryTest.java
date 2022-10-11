package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.Guardian;
import com.example.springDataJPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest   will help u to test your repository after that will flush it
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;

    @Test
    public  void saveStudent(){
        Student student = Student.builder()
                .emailId("aaaa@gmail.com")
                .firstName("shad")
//                .guardianName("dawoi")
//                .guardianEmail("bbb@gmail.com")
//                .quardianMobile("0933579850")
                .build();
        studentRepository.save(student);
    }

    public void  saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("lkk@gmail.com")
                .name("niki")
                .mobile("0933322")
                .build();

        Student student = Student.builder()
                .lastName("shia")
                .emailId("ccc@gmail.com")
                .firstName("Kumar")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("shivam");
        System.out.println("student = " + students);
    }

    @Test
    public  void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findStudentByFirstNameContaining("sh");
        System.out.println("student = " + students);
    }

    @Test
    public void  printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("nikk");
        System.out.println("student = " + students);
    }

    @Test
    public  void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("aabb@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void  printgetStdentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("aabb@gmail.com");
        System.out.println("firstName = " + firstName);
    }


    @Test
    public  void  printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("abc@gmail.com");
        System.out.println("firstName = " + student);
    }

    @Test
    public  void  printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("abc@gmail.com");
        System.out.println("firstName = " + student);
    }




}