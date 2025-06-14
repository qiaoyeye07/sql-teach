package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.StudentCourse;
import com.example.demo.service.StudentCourseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // 允许前端跨域
public class StudentCourseController {

    @Resource
    StudentCourseService studentCourseService;


    // 通过用户名（Sno）查询所选课程
    @GetMapping("/student/courses")
    public List<StudentCourse> getCoursesByUsername(@RequestParam String Sno) {
        return studentCourseService.getCoursesByUsername(Sno);
    }

    // 接收前端选课请求
    @PostMapping("/selectCourse")
    public Result selectCourse(@RequestBody Map<String, String> params) {
        String Sno = params.get("Sno");
        String Cno = params.get("Cno");
        try {
            studentCourseService.insertCourseSelection(Sno, Cno);
            return Result.success("选课成功");
        } catch (Exception e) {
            return Result.error("选课失败：" + e.getMessage());
        }
    }

    // 接收前端退课请求
    @PostMapping("/dropCourse")
    public Result dropCourse(@RequestBody Map<String, String> params) {
        String Sno = params.get("Sno");
        String Cno = params.get("Cno");
        try {
            studentCourseService.deleteCourseSelection(Sno, Cno);
            return Result.success("退课成功");
        } catch (Exception e) {
            return Result.error("退课失败：" + e.getMessage());
        }
    }
}