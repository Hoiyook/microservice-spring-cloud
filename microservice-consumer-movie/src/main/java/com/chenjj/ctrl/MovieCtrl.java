package com.chenjj.ctrl;


import com.chenjj.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class MovieCtrl {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
    }

}
