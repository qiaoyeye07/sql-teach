package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Resource
    CourseService courseService;

    @GetMapping("/course")

    public List<Course> selectCourse(){
        List<Course> courses = courseService.selectCourse();
        return courses;
    }

    @GetMapping("/course/condition")
    public List<Course> selectCourseByCondition(
            @RequestParam(required = false) String cname,
            @RequestParam(required = false) String tname
    ) {
        return courseService.selectCourseByCondition(cname, tname);
    }
}
