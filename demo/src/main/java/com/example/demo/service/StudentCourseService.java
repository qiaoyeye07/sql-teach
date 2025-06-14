package com.example.demo.service;

import com.example.demo.entity.StudentCourse;
import com.example.demo.mapper.StudentCourseMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

    @Resource
    StudentCourseMapper studentCourseMapper;


    public List<StudentCourse> getCoursesByUsername(String Sno) {
        return studentCourseMapper.getCoursesByUsername(Sno);
    }

    public void insertCourseSelection(String Sno, String Cno) {
        studentCourseMapper.insertCourseSelection(Sno, Cno);
    }

    public void deleteCourseSelection(String Sno, String Cno) {
        studentCourseMapper.deleteCourseSelection(Sno, Cno);
    }
}