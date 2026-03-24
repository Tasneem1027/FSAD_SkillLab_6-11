package com.klu.skill_9.controller;

import com.klu.skill_9.model.Student;
import com.klu.skill_9.exception.InvalidInputException;
import com.klu.skill_9.exception.StudentNotFoundException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {

        // Step 1: Check numeric input
        if (!id.matches("\\d+")) {
            throw new InvalidInputException("Invalid input! ID must be a number.");
        }

        int studentId = Integer.parseInt(id);

        if (studentId != 1) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        } 
        return new Student(1, "Maira");
    }
}