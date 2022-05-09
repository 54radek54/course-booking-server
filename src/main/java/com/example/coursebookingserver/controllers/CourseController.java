package com.example.coursebookingserver.controllers;

import com.example.coursebookingserver.exception.AppBasicException;
import com.example.coursebookingserver.model.Course;
import com.example.coursebookingserver.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @RequestMapping(path = {"/courses", "/search"})
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


}
