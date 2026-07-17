package com.Mehre.demo.StudentServer.Controller;

import com.Mehre.demo.StudentServer.Entity.Student;
import com.Mehre.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    public class StudentController {

        StudentService studentService;

        @Autowired
        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @PostMapping("/create")
        public ResponseEntity<Student> storeStudent(@RequestBody Student student) {

            Student result = studentService.studentValidate(student);

            if (result == null) {
                return ResponseEntity.status(400).body(result);
            }

            return ResponseEntity.status(201).body(result);
        }

        @GetMapping("/getStudent/{id}")
        public ResponseEntity<?> getStudentById(@PathVariable int id) {

            Student student = studentService.getStudentById(id);

            if (student == null) {
                return ResponseEntity.status(404).body("Student Not Found");
            }

            return ResponseEntity.status(200).body(student);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateStudent(@PathVariable int id,
                                               @RequestBody Student student) {

            Student updatedStudent = studentService.updateStudent(id, student);

            if (updatedStudent == null) {
                return ResponseEntity.status(404).body("Student Not Found");
            }

            return ResponseEntity.status(200).body(updatedStudent);
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteStudent(@PathVariable int id) {

            boolean deleted = studentService.deleteStudent(id);

            if (!deleted) {
                return ResponseEntity.status(404).body("Student Not Found");
            }

            return ResponseEntity.status(200).body("Student Deleted Successfully");
        }
    }