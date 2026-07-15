package com.Mehre.demo.StudentServer;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

 //   public Student save(Student student) {
   //     System.out.println("Student Information saved");
     //   return student;
    //}
}
