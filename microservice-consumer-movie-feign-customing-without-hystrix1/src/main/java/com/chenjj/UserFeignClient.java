package com.chenjj;

import com.chenjj.entity.User;
import com.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class, fallback = HystrixClientFallBack.class)
public interface UserFeignClient {
    //@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    //自定义的feign，不能用RequestMapping了，需要用@RequestLine
    @RequestLine("GET /simple/{id}")
    public User findById(@Param(value = "id") Long id);


}
