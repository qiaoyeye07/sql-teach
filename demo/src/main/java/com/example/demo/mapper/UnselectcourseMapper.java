package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Unselectcourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UnselectcourseMapper extends BaseMapper<Unselectcourse> {

    List<Unselectcourse> getUnCoursesByUsername(@Param("Sno") String Sno);


}
