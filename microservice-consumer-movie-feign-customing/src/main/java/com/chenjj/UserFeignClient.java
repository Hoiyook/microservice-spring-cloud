package com.chenjj;

import com.chenjj.entity.User;
import com.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class)
public interface UserFeignClient {
    //    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    @RequestLine("GET /simple/{id}")
    public User findById(@Param(value = "id") Long id);


}
