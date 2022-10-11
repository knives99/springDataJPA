package com.example.springDataJPA.repository;

import com.example.springDataJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
//JpaRepository 是 Repository 的JPA 特定擴展它包含用于基本 CRUD 操作的 API，以及用于分页和排序的 API。
public interface StudentRepository  extends JpaRepository<Student,Long> {

    //各種keyWord可參考 https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.namespace-reference
    List<Student> findByFirstName(String firstName);
    //模糊搜尋: findBy想要的參數參數第一個字要改成大寫Containing
    List<Student> findStudentByFirstNameContaining(String name);
    //NotNull 非null搜尋 字尾帶ＮotＮull
    List<Student> findByLastNameNotNull(String name);

    //查詢By物件裡的物件的屬性
    List<Student> findByGuardianName(String name);

    //And條件語句
    Student findByFirstNameAndLastName(String firstName, String lastname);

    //JPQL 是根據attribute property  rather than Database裡的column name
    @Query("SELECT  s from Student s WHERE  s.emailId = ?1")
    Student getStudentByEmailAddress(String emaildId);


    @Query("SELECT  s.firstName from Student s WHERE  s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


    //原生SQL的使用
    @Query(value = "select * from tbl_student s  WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //有多個參數較優化的寫法
    //後面 :emailId 對應 @Param(裡的emailId)
    @Query(value = "select * from tbl_student s  WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId")String emailId);

    //如需修改或刪除需要增加＠Modify Annotation
    @Modifying
    @Transactional
   //@Transactional，本质上是声明了@Transactional(readOnly=false)，这样覆盖了默认的@Transactional配置便可以执行修改操作了。
    @Query(value ="UPDATE tbl_student SET first_name = ?1 WHERE email_address= ?2 ,nativeQuery = true")
    int updateStudentNamedByEmailId(String firstName,String emailId);

}
