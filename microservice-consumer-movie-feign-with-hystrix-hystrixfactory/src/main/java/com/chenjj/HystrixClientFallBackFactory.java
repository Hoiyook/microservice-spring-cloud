package com.chenjj;

import com.chenjj.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallBackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallBackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {


        return (HystrixClientWithFallbackFactory) id -> {
            User user = new User();
            user.setId(-1L);
            logger.error("出错了！{}", throwable.getMessage());
            return user;
        };
    }
}
