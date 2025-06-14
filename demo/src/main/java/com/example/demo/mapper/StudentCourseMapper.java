package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.StudentCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {

    // 通过用户名（Sno）查询所选课程
    List<StudentCourse> getCoursesByUsername(@Param("Sno") String Sno);

    @Insert("INSERT INTO coursestudent (Sno, Cno) VALUES (#{Sno}, #{Cno})")
    void insertCourseSelection(String Sno, String Cno);

    @Delete("DELETE FROM coursestudent WHERE Sno = #{Sno} AND Cno = #{Cno}")
    void deleteCourseSelection(String Sno, String Cno);
}