package com.chenjj.ctrl;


import com.chenjj.UserFeignClient;
import com.chenjj.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class MovieCtrl {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return userFeignClient.findById(id);
    }
}
