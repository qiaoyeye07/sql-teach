package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Resource
    CourseMapper courseMapper;


    public List<Course> selectCourse(){
        return courseMapper.selectCourse();

    }
    //带条件查询
    public List<Course> selectCourseByCondition(String cname, String tname) {
        return courseMapper.selectCourseByCondition(cname, tname);
    }

}
