package com.klu.course.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitle(String title);

}