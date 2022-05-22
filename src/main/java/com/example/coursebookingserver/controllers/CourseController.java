package com.example.coursebookingserver.controllers;

import com.example.coursebookingserver.exception.AppBasicException;
import com.example.coursebookingserver.model.Course;
import com.example.coursebookingserver.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity getAllCourses(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int page) {
        Page<Course> courseList;
        try{
            if (keyword == null) {
                courseList = courseService.getAllCourses(page);
            } else {
                courseList = courseService.getAllCoursesByKeyword(keyword, page);
            }
            if(page>courseList.getTotalPages()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Argument not found!");
            }
            return ResponseEntity.ok().body(courseList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/updateCourse/{id}")
    public ResponseEntity updateCourse(@RequestBody Course course, @PathVariable("id") Long id){
        try{
            if(course!=null && courseService.findCourseById(id)!=null){
                Course updatedCourse=courseService.editCourseById(course,id);
                return ResponseEntity.ok().body(updatedCourse);
            }else {
                throw new AppBasicException("User not found!");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/course")
    public ResponseEntity addCourse(@RequestBody Course course){
        try{
            courseService.addCourse(course);
            return ResponseEntity.ok().body(course);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") Long id) {
        try{
            Course course=courseService.findCourseById(id);
            if(course!=null){
                courseService.deleteCourseById(id);
                return ResponseEntity.ok().body(course);
            }else {
                throw new AppBasicException("User not found!");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/course/{id}")
    public ResponseEntity getCourseById(@PathVariable("id") Long id) {
        try{
            Course course=courseService.findCourseById(id);
            if(course!=null){
                return ResponseEntity.ok().body(course);
            }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
