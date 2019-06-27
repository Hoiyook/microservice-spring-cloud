package com.chenjj;

import com.chenjj.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//fallback和fallbackFactory会有冲突
@FeignClient(name = "microservice-provider-user",
//        fallback = HystrixClientFallback.class,
        fallbackFactory = HystrixClientFallBackFactory.class)
public interface UserFeignClient {


    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    User findById(@PathVariable(value = "id") Long id);
}

