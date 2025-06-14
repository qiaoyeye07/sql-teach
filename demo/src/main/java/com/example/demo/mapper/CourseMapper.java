package com.example.demo.mapper;

import com.example.demo.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course>  selectCourse();

    List<Course> selectCourseByCondition(

            @Param("cname") String cname,
            @Param("tname") String tname
    );
}
