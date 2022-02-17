package com.example.assignment4;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findCourseByCourseId(Integer courseId);
}
