package com.Mehre.demo.StudentServer.Controller;

import com.Mehre.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Mehre.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Mehre.demo.StudentServer.Entity.Student;
import com.Mehre.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(
            @RequestBody CreateStudentRequestDTO createStudentRequestDTO) {

        CreateStudentResponseDTO result =
                studentService.studentValidate(createStudentRequestDTO);

        if (result == null) {
            return ResponseEntity.badRequest().body("Invalid Input");
        }

        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        Student result = studentService.studentUpdate(id, student);

        if (result == null) {
            return ResponseEntity.badRequest().body("Invalid Input");
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        Student student = studentService.deleteStudent(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok("Student Deleted");
    }
}