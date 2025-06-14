package com.example.demo.service;


import com.example.demo.entity.StudentCourse;
import com.example.demo.entity.Unselectcourse;
import com.example.demo.mapper.UnselectcourseMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnselectcourseService {

    @Resource
    UnselectcourseMapper unselectcourseMapper;

    public List<Unselectcourse> getUnCoursesByUsername(String Sno) {
        return unselectcourseMapper.getUnCoursesByUsername(Sno);
    }

}
