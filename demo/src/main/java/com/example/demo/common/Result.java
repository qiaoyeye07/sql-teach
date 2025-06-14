package com.example.demo.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code; // 状态码
    private String msg;   // 消息
    private T data;       // 数据

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
}