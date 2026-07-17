package com.Mehre.demo.StudentServer.Service;

import com.Mehre.demo.StudentServer.Entity.Student;
import com.Mehre.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student studentValidate(Student student) {

        String name = student.getName();
        int age = student.getAge();
        String dept = student.getDept();

        if (name == null || name.isBlank() ||
                age < 0 ||
                dept == null || dept.isBlank()) {
            return null;
        }

        return studentRepository.save(student);
    }
}