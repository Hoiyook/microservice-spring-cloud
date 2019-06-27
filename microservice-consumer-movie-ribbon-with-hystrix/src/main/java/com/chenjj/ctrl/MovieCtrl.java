package com.chenjj.ctrl;


import com.chenjj.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User findById(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    public User findByIdFallBack(Long id) {
        System.out.println("findById方法调用有情况，来到findByIdFallBack");
        User user = new User();
        user.setId(0L);
        return user;
    }
}
