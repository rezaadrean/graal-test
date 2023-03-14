package com.example.reasearch.controller;

import com.example.reasearch.model.Student;
import com.example.reasearch.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student>  listAll() {
        List<Student> listStudents = studentRepo.findAll();

        return listStudents;
    }

    @PostMapping("/studentAdd")
    public List<Student>  add(@RequestBody Map param) {
        Student s = new Student();
        s.setName(param.get("name").toString());
        s.setEmail(param.get("email").toString());
        studentRepo.save(s);
        List<Student> listStudents = studentRepo.findAll();

        return listStudents;
    }

}