package com.example.coursebookingserver.service;

import com.example.coursebookingserver.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

    Page<Course> getAllCourses(int pageable);

    Page<Course> getAllCoursesByKeyword(String keyword, int pageable);

    void deleteCourseById(Long id);

    void addCourse(Course course);

    Course findCourseById(Long id);

    Course editCourseById(Course course, Long id);

}
