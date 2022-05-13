package com.example.coursebookingserver.service.impl;

import com.example.coursebookingserver.exception.AppBasicException;
import com.example.coursebookingserver.model.Course;
import com.example.coursebookingserver.repository.CourseRepository;
import com.example.coursebookingserver.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;

@Service
@RequiredArgsConstructor
public class CourseServiceImplementation implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Page<Course> getAllCourses(int pageable){
        return courseRepository.findAll(PageRequest.of(pageable,10));
    }

    @Override
    public Page<Course> getAllCoursesByKeyword(String keyword, int pageable){
        return courseRepository.findByKeyword(keyword, PageRequest.of(pageable,10));
    }

    @Override
    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }

    @Override
    public void addCourse(Course course) {
        try{
            courseRepository.save(course);
        }catch (PersistenceException e){
            throw new AppBasicException("Course can't be saved!");
        }
    }

    @Override
    public Course findCourseById(Long id){
        return courseRepository.findCourseById(id);
    }

}
