package com.example.coursebookingserver.repository;

import com.example.coursebookingserver.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c where c.name like %:keyword% or c.tutor like %:keyword%")
    Page<Course> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

    Course findCourseById(Long id);
}
