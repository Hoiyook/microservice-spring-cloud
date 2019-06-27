package com.chenjj;

import org.springframework.stereotype.Component;

@Component
public class HystrixClient2FallBack implements FeignClient2 {
    @Override
    public String findInstanceInfoEurekaByServiceName(String serviceName) {
        return "出错了";
    }
}
