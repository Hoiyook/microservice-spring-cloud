package com.chenjj.ctrl;


import com.chenjj.UserFeignClient;
import com.chenjj.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class MovieCtrl {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return userFeignClient.findById(id);
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return userFeignClient.postUser(user);
    }
}
