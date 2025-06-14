package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("studentcourse_view")
public class StudentCourse {

    // 假设 student_id 是联合主键之一
    @TableId(value = "Sno", type = IdType.INPUT)
    private String Sno;

    // 假设 course_id 是联合主键之二，这里不用 @TableId，手动在业务里保证联合主键唯一性
    @TableField("Cno")
    private String cno;
    @TableField("Cname")
    private String cname;
    @TableField("Tname")
    private String tname;
    @TableField("Credit")
    private int    credit;
    @TableField("Ctype")
    private String ctype;
    private String classroomname;
    private String evaluationmode;
}
