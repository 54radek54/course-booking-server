package com.example.coursebookingserver.controllers;

import com.example.coursebookingserver.exception.AppBasicException;
import com.example.coursebookingserver.model.Course;
import com.example.coursebookingserver.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int page) {
        Page<Course> courseList;
        if (keyword == null) {
            courseList = courseService.getAllCourses(page);
        } else {
            courseList = courseService.getAllCoursesByKeyword(keyword, page);
        }
        if(page>courseList.getTotalPages()){
            throw new AppBasicException("Argument not found!");
        }
        return courseList.getContent();
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course) throws AppBasicException {
        courseService.addCourse(course);
        return course;
    }

    @DeleteMapping("/deleteCourse/{id}")
    public Course deleteCourse(@PathVariable("id") Long id) {
        Course course=courseService.findCourseById(id);
        if(course!=null){
            courseService.deleteCourseById(id);
            return course;
        }else {
            throw new AppBasicException("User not found!");
        }
    }

}
