package com.klu.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.course.entity.Course;
import com.klu.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course c = service.addCourse(course);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        List<Course> list = service.getAllCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        Course c = service.updateCourse(course);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        service.deleteCourse(id);
        return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {
        List<Course> list = service.searchByTitle(title);

        if(list.isEmpty()) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}