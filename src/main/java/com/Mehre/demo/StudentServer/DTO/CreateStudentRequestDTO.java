package com.Mehre.demo.StudentServer.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequestDTO {

    @Min(value = 1, message = "Id must be greater than 0")
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;

    @NotBlank(message = "Department is required")
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}