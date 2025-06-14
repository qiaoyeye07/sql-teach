package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")//对应表
public class User {

    @TableId(value = "username")

    private String username;
    private String password;
}
