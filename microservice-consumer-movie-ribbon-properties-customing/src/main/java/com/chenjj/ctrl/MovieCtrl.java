package com.chenjj.ctrl;


import com.chenjj.entity.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class MovieCtrl {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("test")
    public String test() {
        //获得指定的微服务
        ServiceInstance choose = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("11111--->" + choose.getHost() + ":" + choose.getPort() + ":" + choose.getServiceId());
        ServiceInstance choose2 = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("22222--->" + choose2.getHost() + ":" + choose2.getPort() + ":" + choose2.getServiceId());
        return "1";
    }


}
