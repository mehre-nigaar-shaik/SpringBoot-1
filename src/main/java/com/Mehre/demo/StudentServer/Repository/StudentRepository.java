package com.Mehre.demo.StudentServer.Repository;

import com.Mehre.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}