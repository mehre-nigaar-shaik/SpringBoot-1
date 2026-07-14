package com.Mehre.demo.StudentServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //store the stud info , read the stud info with id, update the stud info, delete the stud info from the db

@PostMapping("/create")
public String storeStudent() {
    return """
            id : 1
            name : Mehre
            Dept : CSE
            age : 20
            """;
}


















}
