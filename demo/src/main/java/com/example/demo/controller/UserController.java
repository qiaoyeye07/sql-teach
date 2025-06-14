package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    // 登录接口：接收用户名，返回用户完整信息（含密码）
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> requestData) {
        Map<String, Object> result = new HashMap<>();
        String username = requestData.get("username"); // 仅接收用户名

        User user = userService.findByUsername(username);
        if (user != null) {
            result.put("code", 200);
            result.put("message", "查询用户成功");
            result.put("user", user); // 返回用户对象（含密码）
        } else {
            result.put("code", 404);
            result.put("message", "用户名不存在");
        }
        return result;
    }
}