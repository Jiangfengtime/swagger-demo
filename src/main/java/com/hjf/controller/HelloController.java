package com.hjf.controller;

import com.hjf.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jiang锋时刻
 * @create 2020-09-30 14:40
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/t1")
    public String test01(){
        return "hello world";
    }

    // 只要我们的接口中, 返回值中存在实体类, 他就会被扫描
    @PostMapping("/user/{username}/{password}")
    public User user(@PathVariable("username") String username, @PathVariable("password") String password){
        return new User(username, password);
    }

}
