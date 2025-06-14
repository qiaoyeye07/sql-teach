package com.example.demo.controller;


import com.example.demo.entity.StudentCourse;
import com.example.demo.entity.Unselectcourse;
import com.example.demo.service.UnselectcourseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // 允许前端跨域
public class UnselectcourseController {

    @Resource
    UnselectcourseService unselectcourseService;

    public UnselectcourseController(UnselectcourseService unselectcourseService) {
        this.unselectcourseService = unselectcourseService;
    }

    // 通过用户名（Sno）查询未选课程
    @GetMapping("/student/uncourses")
    public List<Unselectcourse> getUnCoursesByUsername(@RequestParam String Sno) {
        return unselectcourseService.getUnCoursesByUsername(Sno);
    }
}
