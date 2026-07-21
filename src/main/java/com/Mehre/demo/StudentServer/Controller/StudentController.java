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

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        if(result == null)
        {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return  ResponseEntity.status(201).body(result);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){

        CreateStudentResponseDTO student = studentService.getStudentById(id);

        if(student == null){
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody CreateStudentRequestDTO CreateStudentRequestDTO){
        CreateStudentResponseDTO result = studentService.updateStudent(id, CreateStudentRequestDTO);
        if(result == null)
        {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        boolean deleted = studentService.deleteStudent(id);
        if(!deleted) {
            return ResponseEntity.status(400).body("Invalid input");
        }
        return ResponseEntity.status(200).body("Student deleted");
    }
}