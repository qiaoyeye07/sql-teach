package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@TableName("course")//对应表名

@JsonPropertyOrder({
        "cno",
        "cname",
        "tname",
        "credit",
        "ctype",
        "classroomname",
        "evaluationmode"
})
public class Course {

    @TableId(value = "Cno")

    private String Cno;
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
