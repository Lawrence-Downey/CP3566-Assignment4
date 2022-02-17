package com.example.assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.Objects;

@RestController
@RequestMapping(path="/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path = "/addCourse")
    public @ResponseBody String addCourse(@RequestParam String courseName, @RequestParam String courseNumber,
                             @RequestParam String capacity){

        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);

        return "Attempt to add Course: " + course.getCourseName() + " was successful. Congratulations!";
    }

    @GetMapping(path = "/listCourses")
    public @ResponseBody Iterable<Course> getCourses(){
        return courseRepository.findAll();
    }

    @GetMapping(path = "/viewCourse/{id}")
    public @ResponseBody Course viewCourse(@PathVariable Integer id){
        return courseRepository.findCourseByCourseId(id);
    }

}
