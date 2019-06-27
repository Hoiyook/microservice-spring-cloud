package com.chenjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//使用eureka
@EnableFeignClients//使用feign
@EnableCircuitBreaker//用hystrix
public class MicroServiceConsumerMovieFeignWithHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConsumerMovieFeignWithHystrixApplication.class, args);
    }
}
