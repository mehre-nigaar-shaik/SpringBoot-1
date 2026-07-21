package com.Mehre.demo.StudentServer.Service;

import com.Mehre.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Mehre.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Mehre.demo.StudentServer.Entity.Student;
import com.Mehre.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);

        student = studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    // GET
    public CreateStudentResponseDTO getStudentById(int id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        return mapToResponseDTO(student);
    }

    // UPDATE
    public CreateStudentResponseDTO updateStudent(int id,
                                                  CreateStudentRequestDTO createStudentRequestDTO) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        if (createStudentRequestDTO.getName() != null) {
            result.setName(createStudentRequestDTO.getName());
        }

        if (createStudentRequestDTO.getAge() > 0) {
            result.setAge(createStudentRequestDTO.getAge());
        }

        if (createStudentRequestDTO.getDepartment() != null) {
            result.setDepartment(createStudentRequestDTO.getDepartment());
        }

        result.setUpdatedAt(LocalDateTime.now());

        result = studentRepository.save(result);

        return mapToResponseDTO(result);
    }

    // DELETE
    public boolean deleteStudent(int id) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return false;
        }

        studentRepository.delete(result);

        return true;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO dto = new CreateStudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setDepartment(student.getDepartment());

        return dto;
    }
}