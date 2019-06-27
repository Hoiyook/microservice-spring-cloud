package com.chenjj.ctrl;


import com.chenjj.FeignClient2;
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

    @Resource
    private FeignClient2 feignClient2;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable(value = "id") Long id) {

        return userFeignClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable(value = "serviceName") String serviceName) {
        return feignClient2.findInstanceInfoEurekaByServiceName(serviceName);
    }
}
